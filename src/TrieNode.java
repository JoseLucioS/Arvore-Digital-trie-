import java.util.HashMap;

public class TrieNode {
    private boolean isWord;
    private HashMap<Character, TrieNode> children;
    private String text;

    public TrieNode(){
        this.isWord = false;
        this.children = null;
        this.text = "";
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
