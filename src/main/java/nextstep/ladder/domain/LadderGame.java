package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {
    private Names names;
    private Lines lines;
    private final List<LadderResult> results;

    public LadderGame(Names names, Lines lines, List<LadderResult> results) {
        this.names = names;
        this.lines = lines;
        validateResults(results);
        this.results = results;
    }

    public Names getNames() {
        return names;
    }

    public Lines getLines() {
        return lines;
    }

    private void validateResults(List<LadderResult> results) {
        if (results.size() != names.size()) {
            throw new IllegalArgumentException("참가자 수와 결과 수가 일치하지 않습니다.");
        }
    }
}
