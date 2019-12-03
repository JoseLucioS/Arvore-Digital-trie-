import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //TODO criar programa para listar as palavras através da linha de comando
        //TODO criar arquivo .jar

        Trie trie = new Trie();
        trie.insert("amar");
        trie.insert("ameixa");
        trie.insert("amado");
        trie.insert("ameba");
        trie.insert("arvore");
        trie.insert("amadores");
        trie.insert("arbitro");
        trie.insert("armazenar");

        System.out.println("achou amado? " + trie.search("amado"));
        System.out.println("achou amadores? " + trie.search("amadores"));

        trie.remove("amado");
        System.out.println("após remoção:");
        System.out.println("achou amado? " + trie.search("amado"));

        trie.remove("amado");
        System.out.println("achou amadores? " + trie.search("amadores"));

        List<String> list = new ArrayList<>();
        list = trie.autocomplete("am");

        for (String s : list) {
            System.out.println(s);
        }

    }
}
