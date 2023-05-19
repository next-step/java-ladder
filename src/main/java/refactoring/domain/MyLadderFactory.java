package refactoring.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MyLadderFactory implements LadderFatory {

    private final LineFactory myLineFactory;

    public MyLadderFactory(LineFactory myLineFactory) {
        this.myLineFactory = myLineFactory;
    }

    @Override
    public Ladder create(final int depth, final int countOfPlayer) {
        validate(depth);
        List<Line> myLines = new ArrayList<>(depth);
        IntStream.range(0, depth).forEach(i -> myLines.add(i ,myLineFactory.create(countOfPlayer)));
        return new MyLadder(myLines, countOfPlayer);
    }

    private static void validate(final int depth) {
        if(depth <= 0){
            throw new IllegalArgumentException("깊이는 1이상이어야 합니다.");
        }
    }
}
