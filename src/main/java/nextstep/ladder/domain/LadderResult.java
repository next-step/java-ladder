package nextstep.ladder.domain;

import java.util.List;

public class LadderResult {

    private final Ladder ladder;
    private final List<String> results;

    private LadderResult(Ladder ladder, List<String> results) {
        this.ladder = ladder;
        this.results = results;
    }

    public static LadderResult of(Ladder ladder, List<String> results) {
        return new LadderResult(ladder, results);
    }

    public String resultByName(String name) {
        int position = ladder.resultPersonIndex(name);
        return results.get(position);
    }


}
