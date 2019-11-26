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

    //TODO fazer os métodos de inserção, busca e remoção
    //testar esse método para ver se funciona
    public void insert(String text){
        HashMap<Character, TrieNode> child = root.getChildren();
        for(int i = 0; i < text.length(); i++){
            char character = text.charAt(i);
            TrieNode node = new TrieNode();
            if(child.containsKey(character)){
                node = child.get(character);
            } else {
                //node = new TrieNode();
                child.put(character, node);
            }
            child = node.getChildren();

            if(i == text.length() - 1){
                node.setWord(true);
            }
        }
    }

    public boolean search(){
        return false;
    }

    public void remove(String text){

    }
}
