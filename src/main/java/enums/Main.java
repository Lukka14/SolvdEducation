package enums;

// Create 5 complex Enums(with fields, methods, blocks).
// Read text from the file(create the file and copy any text in it)
// and calculate the numbers of the unique words. Write the result to the file.
// The main requirement is: using StringUtils and FileUtils to implement it with minimum lines of code.

import enums.myenums.Directions;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\text\\getdata.txt");
        String text="Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n" +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book.\n" +
                "It has survived not only five centuries, but also the leap into electronic typesetting,\n" +
                "remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset\n" +
                "sheets containing Lorem Ipsum passages, and more recently with desktop publishing software\nlike" +
                "Aldus PageMaker including versions of Lorem Ipsum.";
        FileUtils.write(file,text, StandardCharsets.UTF_8,false);
        String textFromFile = FileUtils.readFileToString(file,"UTF-8");
        int count=0;
        String[] words = textFromFile.split("\\s+");

        Map<String,Integer> map=new HashMap<>();

        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i])){
                map.put(words[i],1);
            }
            if(map.containsKey(words[i])){
                int j=map.get(words[i]);
                j++;
                map.put(words[i],j);
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            // do what you have to do here
            // In your case, another loop.
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        String word="the";
        String tmp=textFromFile;
        for(int i=0;i<words.length;i++){
            if(StringUtils.contains(tmp,word)){
                tmp=tmp.replaceFirst(word," ");
                count++;
            }
        }
        File result=new File("D:\\text\\result.txt");
        FileUtils.write(result,"It contains " + count+"x word "+word,"UTF-8", false);
//        Desktop.getDesktop().open(result);


        Directions d=Directions.EAST;
        System.out.println(d.getDirName());

        String test="test";
        test=Arrays.toString(text.split("a"));
        System.out.println(test);

    }
}
