package streaming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class streamingMain {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Rudolph");
        names.add("Joshua");
        names.add("Derek");
        names.add("John");
        List<String> namesStartWithJ = names.stream().filter( (str) -> {
            char[] chars = str.toCharArray();
            return chars[0] == 'j' || chars[0] == 'J';
        } ).collect(Collectors.toList());
        System.out.println(namesStartWithJ);

        names.stream().map( s -> s.toUpperCase());

        System.out.println(names);


    }
}
