package nextstep.ladder.domain;

import java.util.HashMap;
public class ResultOfGame {

    private Names names;
    private HashMap<Integer, Integer> result;

    public ResultOfGame(Names names, HashMap<Integer, Integer> result) {
        this.names = names;
        this.result = result;
    }

    public Integer targetResult(String wantToKnow) {
        return result.get(index(wantToKnow));
    }

    private int index(String wantToKnow) {
        return names.index(wantToKnow);
    }
}
