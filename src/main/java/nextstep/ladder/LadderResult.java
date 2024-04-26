package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    private List<Integer> result = new ArrayList<>();

    public void add(int resultPosition) {
        result.add(resultPosition);
    }

    public Integer findResult(int index) {
        return result.get(index);
    }
}
