package nextstep.ladder.model;

import java.util.LinkedHashMap;

public class LadderResult {
    private LinkedHashMap<Player, Prize> result;

    public LadderResult(LinkedHashMap<Player, Prize> result) {
        this.result = result;
    }

    public LinkedHashMap<Player, Prize> getResult() {
        return result;
    }
}
