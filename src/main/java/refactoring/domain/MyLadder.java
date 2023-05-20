package refactoring.domain;

import java.util.List;
import java.util.stream.IntStream;

public class MyLadder implements Ladder{

    private final List<Line> myLines;
    private final int countOfPlayer;

    public MyLadder(final List<Line> myLines, final int countOfPlayer) {
        this.myLines = myLines;
        this.countOfPlayer = countOfPlayer;
    }

    @Override
    public Match match(Results results, Match matchResults) {
        validate(results);
        IntStream.range(0, countOfPlayer).forEach(i -> matchResults.put(i, getResult(i, results)));
        return matchResults;
    }

    @Override
    public List<Line> get() {
        return myLines;
    }

    private void validate(final Results results) {
        if (results.size() != countOfPlayer){
            throw new IllegalArgumentException("참여자와 실행결과의 수가 일치하지 않습니다.");
        }
    }

    private String getResult(final int position, final Results results) {
        int target = position;
        for (Line myLine : myLines) {
            target = myLine.toResult(target);
        }
       return results.get(target);
    }
}
