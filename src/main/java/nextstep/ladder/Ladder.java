package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines; // todo: 일급컬렉션
    private final int height; // todo: height 유효성 검사

    public Ladder(int height) {
        this(height, new ArrayList<>());
    }

    public Ladder(int height, List<Line> lines) {
        this.height = height;
        this.lines = lines;
    }

    public List<Line> create(int countOfPerson) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
        return lines;
    }

    public int move(int position) {
        int result = position;
        for (Line line : lines) {
            result = line.move(result);
        }
        return result;
    }
}
