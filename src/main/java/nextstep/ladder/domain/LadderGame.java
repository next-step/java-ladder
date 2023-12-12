package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public LadderResults play() {
        Map<Name, LadderResult> gameResults = generateGameResults();
        return new LadderResults(gameResults);
    }

    public Names getNames() {
        return names;
    }

    public Lines getLines() {
        return lines;
    }

    private Map<Name, LadderResult> generateGameResults() {
        return IntStream.range(0, names.size())
                .boxed()
                .collect(Collectors.toMap(names.getNames()::get, this::calculateResult));
    }

    private LadderResult calculateResult(int index) {
        return results.get(lines.move(index));
    }

    private void validateResults(List<LadderResult> results) {
        if (results.size() != names.size()) {
            throw new IllegalArgumentException("참가자 수와 결과 수가 일치하지 않습니다.");
        }
    }
}
