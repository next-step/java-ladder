package ladder.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
@ToString
@EqualsAndHashCode
public class Ladder {
    public static final int MIN_FLOOR = 2;
    private List<Line> lines = new ArrayList<>();
    private GameResults gameResults;

    public Ladder(int countOfPerson, int height, List<String> gameResults) {
        validateHeight(height);
        initLine(countOfPerson, height);
        this.gameResults = new GameResults(gameResults);
    }

    public Ladder(List<Line> lines, List<String> gameResults) {
        validateHeight(lines.size());
        this.lines = lines;
        this.gameResults = new GameResults(gameResults);
    }

    public GameResult move(int index) {
        int pointResult = movePoint(index);
        return gameResults.getGameResult(pointResult);
    }

    private void validateHeight(int height) {
        if(height < MIN_FLOOR) {
            throw new IllegalArgumentException("적어도 2층정돈 해줘야죠ㅠㅠ");
        }
    }

    private void initLine(int countOfPerson, int height) {
        IntStream.range(0, height).forEach(count -> lines.add(new Line(countOfPerson)));
    }

    private int movePoint(int index) {
        int pointIndex = index;
        for (Line line : lines) {
            pointIndex = line.movePoint(pointIndex);
        }
        return pointIndex;
    }
}
