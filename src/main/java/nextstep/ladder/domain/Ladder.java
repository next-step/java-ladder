package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final LadderHeight height;

    private final List<Line> lines;

    private final LadderResult ladderResult;


    public Ladder(int height, int length, LineGenerator lineGenerator, List<String> results) {
        this.height = new LadderHeight(height);
        this.ladderResult = new LadderResult(results, length + 1);
        this.lines = Stream.generate(() -> new Line(length, lineGenerator))
                .limit(height)
                .collect(Collectors.toUnmodifiableList());
    }

    public GameResult getGameResult(Users users) {
        List<String> orderLadderResult = matchLadderResultByOrder();
        return new GameResult(orderLadderResult, users);
    }

    private List<String> matchLadderResultByOrder() {

        List<String> orderLadderResult = new ArrayList<>();

        for (int i = 0; i < ladderResult.getResults().size(); i++) {
            orderLadderResult.add(ladderResult.getResults().get(findIndex(lines, i)));
        }

        return orderLadderResult;
    }

    private int findIndex(List<Line> lines, int startIndex) {
        int nextIndex = startIndex;

        for (Line line : lines) {
            nextIndex = line.nextIndex(nextIndex);
        }

        return nextIndex;
    }



    public int getHeight() {
        return height.getHeight();
    }

    public List<Line> getLines() {
        return lines.stream().collect(Collectors.toUnmodifiableList());
    }

    public List<String> getLadderResult() {
        return ladderResult.getResults();
    }
}
