package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultOfGame {

    private Names names;
    private HashMap<Integer, Integer> result;

    public ResultOfGame(Names names, HashMap<Integer, Integer> result) {
        this.names = names;
        this.result = result;
    }

    public Names names(){
        return names;
    }

    public Integer targetResult(String wantToKnow) {
        return result.get(index(wantToKnow));
    }

    public List<Integer> allResult() {
        List<Integer> allResults = new ArrayList<>();
        allResults.addAll(result.values());
        return allResults;
    }
    private int index(String wantToKnow) {
        return names.index(wantToKnow);
    }
}
