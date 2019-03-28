package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLineResult {
    private final List<String> ladderLineResult;

    public LadderLineResult(EndPoints participants, LadderLines ladderLines, EndPoints rewards) {
        ladderLineResult = getLadderLineResult(participants, ladderLines, rewards);
    }

    private List<String> getLadderLineResult(EndPoints participants, LadderLines ladderLines, EndPoints rewards) {
        List<String> ladderLineStrings = new ArrayList<>();
        ladderLineStrings.add(participants.toString());
        ladderLineStrings.add(ladderLines.toString());
        ladderLineStrings.add(rewards.toString());
        return ladderLineStrings;
    }

    public List<String> getLadderLineResult() {
        return ladderLineResult;
    }
}