package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchingResult {
    private final List<Integer> startToEnd = new ArrayList<>();

    public void add(int start, int end) {
        this.startToEnd.add(start, end);
    }

    public int getResult(int index) {
        return this.startToEnd.get(index);
    }

    public List<Integer> asList() {
        return this.startToEnd;
    }
}
