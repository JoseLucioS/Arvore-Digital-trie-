import java.util.HashMap;

public class Trie {
    private TrieNode root;

    //construtor
    public Trie(){
        this.root = new TrieNode();
    }

    //getter
    public TrieNode getRoot() {
        return root;
    }

    //setter
    public void setRoot(TrieNode root){
        this.root = root;
    }

    //inserção funcionando
    public void insert(String text){
        HashMap<Character, TrieNode> child = root.getChildren();
        for(int i = 0; i < text.length(); i++){
            char character = text.charAt(i);
            TrieNode node = new TrieNode();
            if(child.containsKey(character)){
                node = child.get(character);
            } else {

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

    //TODO fazer o método de remoção
    public void remove(String text){
        if(this.search(text)){

        } else {
            
        }
    }

    //TODO fazer método de autocompletar
}
