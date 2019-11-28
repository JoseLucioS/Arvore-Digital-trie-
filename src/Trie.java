import java.util.*;

public class Trie {
    private TrieNode root;

    //construtor padrao
    public Trie(){
        this.root = new TrieNode();
    }

    //inserção funcionando
    public void insert(String text){
        if(text == null || text.length() == 0){
            return;
        }

        HashMap<Character, TrieNode> child = root.getChildren();
        for(int i = 0; i < text.length(); i++){
            char character = text.charAt(i);
            TrieNode node = new TrieNode();
            if(child.containsKey(character)){
                node = child.get(character);
            } else {
                node.setText(character);
                child.put(character, node);
            }
            child = node.getChildren();

            if(i == text.length() - 1){
                node.setWord(true);
            }
        }
    }

    //busca funcionando
    public boolean search(String text){

        HashMap<Character, TrieNode> child = root.getChildren();
        TrieNode node = null;

        for(int i = 0; i < text.length(); i++){
            char character = text.charAt(i);
            if(child.containsKey(character)){
                node = child.get(character);
                child = node.getChildren();
            } else {
                node = null;
                break;
            }
        }

        if(node != null && node.isWord()){
            return true;
        } else {
            return false;
        }

    }

    //remoção funcionando
    public void remove(String text){
        HashMap<Character, TrieNode> child = root.getChildren();
        TrieNode node = new TrieNode();
        List<TrieNode> list = new ArrayList<>(text.length());

        if(search(text)){
            for(int i = 0; i < text.length(); i++) {
                char character = text.charAt(i);
                node = child.get(character);
                child = node.getChildren();
                list.add(node);

            }

//            int size = list.size();
//            list.get(size-1).setWord(false);

            for (int i = list.size()-1; i > 0; i--) {
                if (list.get(i).getChildren().isEmpty() && !list.get(i).isWord()) {
                    list.get(i-1).getChildren().remove(list.get(i).getText());
                    list.remove(i);
                } else {
                    list.get(i).setWord(false);
                    break;
                }
            }
        } else {
            System.out.println("palavra inexistente");
        }

    }

    //TODO fazer método de autocompletar
    public List autocomplete(String prefix){
        HashMap<Character, TrieNode> child = root.getChildren();
        List<String> words = new ArrayList<String>();
        String word;
        TrieNode node;

        //percorrer até achar node com o último caracter do prefixo, só então começar a procurar por palavras
        //correspondentes e guardá-las no arraylist
//        for(){
//
//        }

        Collections.sort(words);
        return words;
    }

    //TODO fazer a sobrecarga do método de autocompletar
//    public List<String> autocomplete(String prefix, int size){
//
//    }
}
