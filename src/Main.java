public class Main {
    public static void main(String[] args) {
        //TODO criar programa para listar as palavras através da linha de comando
        //TODO criar arquivo .jar
        //TODO criar a classe de testes
        Trie trie = new Trie();
        trie.insert("amar");
        trie.insert("ameixa");
        trie.insert("amado");
        trie.insert("ameba");
        trie.insert("arvore");
        trie.insert("digital");

        System.out.println("achou amador? " + trie.search("amador"));
    }
}
