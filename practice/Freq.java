import java.util.HashMap;
import java.util.Map;

public class Freq {
    public static Map<String,Integer> findFreq(String line){
        line.toLowerCase();
        String[] words=line.split("//s+");
        Map<String,Integer> freqmap=new HashMap<>();
        for(String word:words){
            freqmap.put(word,freqmap.getOrDefault(word,0 ), null))
        }
        return freqmap;
    }
}
