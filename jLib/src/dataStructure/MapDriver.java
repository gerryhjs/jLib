package dataStructure;

import java.util.HashMap;
import java.util.Map;

public class MapDriver {
    public static void main( String[] agrs)
    {
        Map<String,Integer> map=new HashMap<>();
        map.put("aaa",1);
        System.out.println(map.get("aaa"));

    }

}
