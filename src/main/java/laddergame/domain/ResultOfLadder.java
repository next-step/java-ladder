package laddergame.domain;

import java.util.List;

public class ResultOfLadder {
    private final List<WinningContent> results;

    private ResultOfLadder(List<WinningContent> results) {
        this.results = results;
    }

    public static ResultOfLadder valueOf(List<WinningContent> results) {
        return new ResultOfLadder(results);
    }

    public WinningContent findResultByIndex(int index) {
        return results.get(index);
    }
}
