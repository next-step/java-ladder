package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {

    Map<String, String> ladderGameResult = new HashMap<>();

    public LadderGameResult(LadderMember ladderMember, List<Integer> resultOfGame) {
        int index = 0;
        for(Integer i : resultOfGame) {
            ladderGameResult.put(ladderMember.memberNo(i), ladderMember.resultNo(index));
            index++;
        }
    }

    public Map<String, String> getLadderGameResult() {
        return ladderGameResult;
    }

    public String showMemberResult(String memberName) {
        String displayResult = "";
        if(!memberName.equals("all")) {
            return memberResult(memberName);
        }
        for(Map.Entry<String, String> entry : ladderGameResult.entrySet()) {
            displayResult += entry.getKey() + " : " + entry.getValue() + "\n";
        }
        return displayResult;
    }

    private String memberResult(String s) {
        String string = "";
        for(Map.Entry<String, String> entry : ladderGameResult.entrySet()) {
            if(s.equals(entry.getKey())) {
                string = entry.getValue();
            }
        }
        return string;
    }
}
