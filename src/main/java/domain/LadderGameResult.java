package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {

    Map<String, Integer> ladderGameResult = new HashMap<>();

    public LadderGameResult(String[] memberArr, List<Integer> resultOfGame) {
        int index = 0;
        for(Integer i : resultOfGame) {
            ladderGameResult.put(memberArr[index], i);
            index++;
        }
    }

    public String showMemberResult(String memberName, String[] result) {
        String displayResult = "";
        if(!memberName.equals("all")) {
            return memberResult(memberName, result);
        }
        for(Map.Entry<String, Integer> entry : ladderGameResult.entrySet()) {
            displayResult += entry.getKey() + " : " + result[entry.getValue()] + "\n";
        }
        return displayResult;
    }

    private String memberResult(String s, String[] result) {
        String string = "";
        for(Map.Entry<String, Integer> entry : ladderGameResult.entrySet()) {
            if(s.equals(entry.getKey())) {
                string = result[entry.getValue()];
            }
        }
        return string;
    }
}
