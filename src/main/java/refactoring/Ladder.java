package refactoring;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;
    private final int countOfPlayer;

    public Ladder(final List<Line> lines, final int countOfPlayer) {
        this.lines = lines;
        this.countOfPlayer = countOfPlayer;
    }

    public MatchResults match(Results results) {
        validate(results);
        MatchResults matchResults = new MatchResults();
        IntStream.range(0, countOfPlayer).forEach(i -> matchResults.put(i, getResult(i, results)));
        return matchResults;
    }

    private void validate(final Results results) {
        if (results.size() != countOfPlayer){
            throw new IllegalArgumentException("참여자와 실행결과의 수가 일치하지 않습니다.");
        }
    }

    private String getResult(final int position, final Results results) {
        int target = position;
        for (Line line : lines) {
            target = line.toResult(target);
        }
       return results.get(target);
    }
}
