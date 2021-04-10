package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {
    private final Ladder ladder;
    private final Results results;

    public LadderResults(Ladder ladder, Results results) {
        validation(ladder, results);
        this.ladder = ladder;
        this.results = results;
    }

    private void validation(Ladder ladder, Results results) {
        if (results.size() != ladder.pointSize())
            throw new IllegalArgumentException("사다리 결과는 사다리 참가자 수와 같아야 합니다.");
    }

    public String getLadderResult(int startPosition) {
        return getResult(ladder.resultPosition(startPosition));
    }

    private String getResult(int position) {
        return results.getResults()
                .stream()
                .filter(result -> result.position() == position)
                .findFirst()
                .map(Result::value)
                .orElseThrow(() -> new IllegalArgumentException("결과 순번을 확인해 주세요."));
    }

    public Results results(){
        return results;
    }

    public List<Line> getLines() {
        return ladder.lines();
    }

    public static LadderResults of(Ladder ladder, Results results) {
        return new LadderResults(ladder, results);
    }
}
