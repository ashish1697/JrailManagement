import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapSorting{

    public static void main(String args[]) throws ParseException {
    	BufferedReader reader;
    	HashMap<Integer, String> fileVlaues = new HashMap<Integer, String>();
    	HashMap<Integer, String> codenames = new HashMap<Integer, String>();
    	 int count =1;
    	try {
			reader = new BufferedReader(new FileReader(
					"/Users/Ashish/newtext.txt"));
			String line = reader.readLine();
			while (line != null) {
				fileVlaues.put(count,line);
				codenames.put(count,line.substring(73,76));
				count++;
				line = reader.readLine();
			} 
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
             
        Comparator<Entry<Integer, String>> valueComparator = new Comparator<Entry<Integer,String>>() {
            
            @Override
            public int compare(Entry<Integer, String> e1, Entry<Integer, String> e2) {
                String v1 = e1.getValue();
                String v2 = e2.getValue();
                return v1.compareTo(v2);
            }
        };

        List<Entry<Integer, String>> listOfEntries = new ArrayList<Entry<Integer, String>>(codenames.entrySet());
        
        // sorting HashMap by values using comparator
        Collections.sort(listOfEntries, valueComparator);
        
        LinkedHashMap<Integer, String> sortedByValue = new LinkedHashMap<Integer, String>(listOfEntries.size());
        
        // copying entries from List to Map
        for(Entry<Integer, String> entry : listOfEntries){
            sortedByValue.put(entry.getKey(), entry.getValue());
            
        }
        System.out.println("Sorted Country codes");
        Set<Entry<Integer, String>> entrySetSortedByValue = sortedByValue.entrySet();
        ArrayList<String> FinalSortedLines = new ArrayList<String>();
        for(Entry<Integer, String> mapping : entrySetSortedByValue){
        	FinalSortedLines.add(fileVlaues.get(mapping.getKey()));
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }
       // System.out.println(FinalSortedLines);
    }

    
}