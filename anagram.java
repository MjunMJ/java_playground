//Solution for question 4 of https://www.codecademy.com/resources/blog/java-code-challenges-for-beginners/

import java.lang.reflect.Array;
import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static String sortWord(String string){
        char[] chr=string.toCharArray();
        Arrays.sort(chr);
        return String.valueOf(chr);

    }//end word sorter
    public static void main(String[] args) {
        String[] input = {"tar", "rat","art","meats","steam"};
        Map<String, List<String>> sortWordPair = new HashMap<>();
        List<String> words = new ArrayList<String>();
        for (String l:input){
            String key = sortWord(l);
            sortWordPair.put(key, words);
        }
        System.out.println(sortWordPair.get("art"));
        for (String l:input) {
            String key = sortWord(l);
            if (sortWordPair.containsKey(key)) {
                sortWordPair.get(key).add(l);
            }
        }
        System.out.println(sortWordPair);
    }//end main
}
