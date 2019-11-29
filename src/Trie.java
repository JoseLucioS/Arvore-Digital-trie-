import java.util.*;

public class Trie {
    private TrieNode root;
    private List<String> words = new ArrayList<>();

    public TrieNode getRoot() {
        return root;
    }

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
        if(text == null || text.length() == 0){
            return false;
        }

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

//    public List autocomplete(String prefix){
//        TrieNode node = searchNode(prefix);
//        List<String> list;
//
//        list = searchWords(node);
//        System.out.println(list);
//
//        return list;
//
//    }
//
//    private TrieNode searchNode(String prefix){
//
//        TrieNode node = getRoot();
//
//        for(int i = 0; i < prefix.length(); i++){
//            char character = prefix.charAt(i);
//            TrieNode newNode = node.getChildren().get(character);
//
//            if(newNode == null){
//                return null;
//            }
//
//            node = newNode;
//
//        }
//
//        return node;
//    }
//
//    private List searchWords(TrieNode node){
//        List<String> list = new ArrayList<>();
//
//        if(node.isWord()){
//            list.add(node.getText());
//        }
//
//        if(!node.getChildren().isEmpty()){
//            for (TrieNode son: node.getChildren().values()) {
//                list.addAll(searchWords(son));
//            }
//        }
//
//        return list;
//    }


    public List autocomplete(String prefix){
        HashMap<Character, TrieNode> child = root.getChildren();
        List<String> words = new ArrayList<String>();
        StringBuilder word = new StringBuilder();
        TrieNode node = new TrieNode();

        //percorrer até achar node com o último caracter do prefixo, só então começar a procurar por palavras
        //correspondentes e guardá-las no arraylist
        for(int i = 0; i < prefix.length(); i++){
            char character = prefix.charAt(i);
            if(child.containsKey(character)){
                //word.append(character);
                node = child.get(character);
                child = node.getChildren();
            } else {
                System.out.println("Não existem palavras com esse prefixo");
                return null;
            }
        }

        words = searchWords(node);

        Collections.sort(words);
        return words;
    }

    public List searchWords(TrieNode node){
        List<String> list = new ArrayList<>();

        if(node.isWord()){
            list.add(""+node.getText());
        }

        if(node.getChildren().isEmpty()){
            return list;
        } else {
            for (char c: node.getChildren().keySet()) {
                List<String> childs = searchWords(node.getChildren().get(c));
                for(String s : childs){
                    list.add(node.getText()+"");
                }
            }

            return list;
        }
    }

    //TODO fazer a sobrecarga do método de autocompletar
//    public List<String> autocomplete(String prefix, int size){
//
//    }

}
