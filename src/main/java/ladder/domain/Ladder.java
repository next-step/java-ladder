package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private static final int HEIGHT_MINIMUM_NUMER = 1;

    private List<Line> lines = new ArrayList<>();

    public Ladder(int height, int countOfPerson) {
        if(validate(height)) {
            throw new IllegalArgumentException("높이값 오류");
        }
        for (int i = 0; i < height; i++) {
            this.lines.add(new Line(countOfPerson));
        }
    }

    private boolean validate(int height) {
        return height < HEIGHT_MINIMUM_NUMER;
    }

    public int getLineHeight() {
        return this.lines.size();
    }

    public Line getDrawLine(int linePosition) {
        return lines.get(linePosition);
    }

}
