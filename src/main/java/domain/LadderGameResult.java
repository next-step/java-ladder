package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LadderGameResult {

    Map<String, Integer> map = new HashMap<>();

    public LadderGameResult(String[] memberArr, ArrayList<Integer> integers) {
        int index = 0;
        for(Integer i : integers) {
            map.put(memberArr[index], i);
            index++;
        }
    }

    public String showMemberResult(String s, String[] result) {
        String string = "";
        if(!s.equals("all")) {
            return memberResult(s, result);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            string += entry.getKey() + " : " + result[entry.getValue()] + "\n";
        }
        return string;
    }

    private String memberResult(String s, String[] result) {
        String string = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(s.equals(entry.getKey())) {
                string = result[entry.getValue()];
            }
        }
        return string;
    }
}
