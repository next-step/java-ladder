package nextstep.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    private final List<String> result;
    private final List<Integer> resultIndex = new ArrayList<>();

    public LadderResult(List<String> result) {
        this.result = result;
    }

    public void addResultIndex(int resultIndex) {
        this.resultIndex.add(resultIndex);
    }

    public List<String> getResult() {
        return result;
    }

    public List<Integer> getResultIndex() {
        return resultIndex;
    }

}
