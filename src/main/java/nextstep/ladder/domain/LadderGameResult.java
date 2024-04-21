package nextstep.ladder.domain;

import java.util.Map;

public class LadderGameResult {
    private Map<String,String> result;
    public LadderGameResult(Map<String, String> result) {
        this.result = result;
    }

    public String getSingleResult(String interestingPerson) {
        return result.get(interestingPerson);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : result.entrySet()) {
            sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
        }
        return sb.toString().trim();
    }

}
