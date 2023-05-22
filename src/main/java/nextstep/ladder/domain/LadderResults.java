package nextstep.ladder.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LadderResults {
    private List<LadderResult> ladderResultList = new ArrayList<>();

    public LadderResults(List<String> results) {
        for (String result : results) {
            ladderResultList.add(new LadderResult(result));
        }
    }

    public String status() {
        String result = "";
        for (LadderResult ladderResult : ladderResultList) {
            result += ladderResult.getResult() + " ";
        }
        return result;
    }
}
