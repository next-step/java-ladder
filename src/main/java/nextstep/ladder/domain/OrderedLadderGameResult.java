package nextstep.ladder.domain;

import java.util.LinkedHashMap;

public class OrderedLadderGameResult extends LadderGameResult {
    public OrderedLadderGameResult() {
        this.ladderGameResult = new LinkedHashMap<>();
    }
}
