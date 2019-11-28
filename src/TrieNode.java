import java.util.HashMap;

public class TrieNode {
    private boolean isWord;
    private HashMap<Character, TrieNode> children;
    private char text;

    public TrieNode(){
        this.isWord = false;
        this.children = new HashMap<Character, TrieNode>();
    }

    public TrieNode(char text){
        this.isWord = false;
        this.children = new HashMap<Character, TrieNode>();
        this.text = text;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }

    public char getText() {
        return text;
    }

    public void setText(char text) {
        this.text = text;
    }
}
