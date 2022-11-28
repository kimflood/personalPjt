import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * API 의 전체 목록으로 각각의 Count를 추출 
 */
public class ApiCounts {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new FileReader("C:\\Users\\USER\\Downloads\\all_api")
        );

        HashMap<String, Integer> map = new HashMap<>();

        String str;
        while ((str = reader.readLine()) != null) {
            if (!map.containsKey(str)) {
                map.put(str,1);
            }else{
                map.put(str,map.get(str)+1);
            }
        }

        List<Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());

        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int n = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
            n++;

            if ( n == 30 ) { break; }
        }


        //System.out.println(map);
        reader.close();
    }
}
