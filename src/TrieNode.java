import java.util.*;

public class TrieNode {
    private boolean isWord;
    private HashMap<Character, TrieNode> children;
    private String text;

    public TrieNode(){
        this.isWord = false;
        this.children = new HashMap<Character, TrieNode>();
    }

    public TrieNode(String text){
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getPrefixes() {
        List<String> words = new ArrayList<>();

        if(this.isWord()){
            words.add(this.getText()+"");
        }

        for(Map.Entry<Character, TrieNode> input : children.entrySet()){
            TrieNode c = input.getValue();
            System.out.println(c.getText());
            List<String> cp = c.getPrefixes();
            words.addAll(cp);
        }

        return words;
    }

    protected List<String> getSuffixes() {

        List<String> words = new ArrayList<>();

        if(isWord()){
            words.add(getText());
            return words;
        }

        for(TrieNode child : children.values()){
            List<String> chWords = child.getSuffixes();
            for (String chWord : chWords) {
                words.add(text + chWord);
            }
        }

        return words;
    }
}
