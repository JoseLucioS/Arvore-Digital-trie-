import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrieTest {


    @Test
    public void trieMustBeNotEmptyAfterInsert(){
        Trie trie = new Trie();

        trie.insert("pokemon");

        assertFalse(trie.getRoot().getChildren().isEmpty());
    }

    @Test
    public void trieMustBeEmptyAfterInsert(){
        Trie trie = new Trie();
        String text = null;

        trie.insert(text);

        assertTrue(trie.getRoot().getChildren().isEmpty());
    }

    @Test
    public void MustFindAWord(){
        Trie trie = new Trie();
        trie.insert("maravilha");
        trie.insert("mar");
        trie.insert("marcado");

        assertTrue(trie.search("maravilha"));
        assertTrue(trie.search("mar"));
        assertTrue(trie.search("marcado"));
    }

    @Test
    public void MustNotFindAWord(){
        Trie trie = new Trie();
        trie.insert("maravilha");
        trie.insert("mar");
        trie.insert("marcado");

        assertFalse(trie.search("maravilhosa"));
        assertFalse(trie.search("marcaçao"));
        assertFalse(trie.search("ma"));
        assertFalse(trie.search(null));
    }

    @Test
    public void MustNotFindAWordDeleted(){
        Trie trie = new Trie();
        trie.insert("maravilha");
        trie.insert("mar");
        trie.insert("marcado");
        trie.insert("pokemon");

        assertTrue(trie.search("marcado"));

        trie.remove("marcado");

        assertTrue(trie.search("maravilha"));
        assertFalse(trie.search("marcado"));
        assertTrue(trie.search("mar"));

    }


    @Test
    public void MustAutoComplete(){
        Trie trie = new Trie();
        List<String> list = new ArrayList<>();

        trie.insert("maravilha");
        trie.insert("mar");
        trie.insert("marcado");
        trie.insert("pokemon");
        trie.insert("palito");

        list = trie.autocomplete("mar");

        assertTrue(list.get(0).equals("mar"));

        list = trie.autocomplete("po");

        assertTrue(list.get(0).equals("pokemon"));
        assertFalse(list.get(0).equals("palito"));


    }

}