import java.util.List;

public class TestaAutocomplete {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("amar");
        trie.insert("amor");
        trie.insert("amei");
        trie.insert("amado");
        trie.insert("ameixa");
        trie.insert("amaria");
        trie.insert("amazing");
        trie.insert("amazon");
        trie.insert("amadores");
        trie.insert("amador");
        trie.insert("ambulancia");
        trie.insert("ambev");
        trie.insert("amoroso");
        trie.insert("ampulheta");

        List<String> list = trie.autocomplete("am");

        for (String s:list) {
            System.out.println(s);
        }

    }
}
