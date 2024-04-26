package nextstep.ladder.domain.rdd;

import nextstep.ladder.interfaces.LadderResult;

import java.util.ArrayList;
import java.util.List;

public class GameLadderResult implements LadderResult {
    private final List<Integer> result = new ArrayList<>();

    @Override
    public void add(int resultPosition) {
        result.add(resultPosition);
    }

    public List<Integer> getResults() {
        return result;
    }
}
