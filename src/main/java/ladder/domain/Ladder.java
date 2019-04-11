package ladder.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
@ToString
@EqualsAndHashCode
public class Ladder {
    public static final int MIN_FLOOR = 2;

    public Ladder(int countOfPerson, int height) {
        validateHeight(height);
        initLine(countOfPerson, height);
    }

    private List<Line> lines = new ArrayList<>();

    protected void setLines(List<Line> lines) {
        this.lines = lines;
    }

    private void validateHeight(int height) {
        if(height < MIN_FLOOR) {
            throw new IllegalArgumentException("적어도 2층정돈 해줘야죠ㅠㅠ");
        }
    }

    private void initLine(int countOfPerson, int height) {
        IntStream.range(0, height).forEach(count -> lines.add(new Line(countOfPerson)));
    }

    public int move(int index) {
        final int[] pointIndex = {index};
        IntStream.range(0, lines.size()).forEach(lineIndex -> pointIndex[0] = lines.get(lineIndex).movePoint(pointIndex[0]));
        return pointIndex[0];
    }
}
