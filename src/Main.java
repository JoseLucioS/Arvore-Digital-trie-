import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Trie trie = new Trie();
        if(args.length < 2){
            System.out.println("Script inválido. Tente o seguinte:");
            System.out.println("java -jar trie.jar arquivo.txt prefixo tamanhoDoRetorno");

        } else if(args.length < 3){
            try {
                FileReader file = new FileReader(args[0]);
                BufferedReader readFile = new BufferedReader(file);
                String word = readFile.readLine();

                while(word != null){
                    trie.insert(word);
                    word = readFile.readLine();
                }

                file.close();

                List<String> list;
                list = trie.autocomplete(args[1]);
                //list = trie.autocomplete("am"); //testando antes de gerar o .jar - OK
                for (String s : list) {
                    System.out.println(s);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

            try {
                FileReader file = new FileReader(args[0]);
                BufferedReader readFile = new BufferedReader(file);
                String word = readFile.readLine();

                while(word != null){
                    trie.insert(word);
                    word = readFile.readLine();
                }

                file.close();

                List<String> list;
                int value = Integer.valueOf(String.valueOf(args[2]));
                list = trie.autocomplete(args[1], value);

                for (String s : list) {
                    System.out.println(s);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
