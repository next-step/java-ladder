package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private static final String INIT_HEIGHT = "  |";
    private static final String TRUE_WIDTH = "-----|";
    private static final String FALSE_WIDTH = "     |";

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    public List<String> getLines() {
        return lines.stream()
                .map(line -> makeStringLine(line.getPoints()))
                .collect(Collectors.toList());
    }

    private String makeStringLine(List<Boolean> lines) {
        StringBuilder stringLine = new StringBuilder();
        stringLine.append(INIT_HEIGHT);

        for (Boolean line : lines) {
            if (line) {
                stringLine.append(TRUE_WIDTH);
            } else {
                stringLine.append(FALSE_WIDTH);
            }
        }

        return stringLine.toString();
    }
}
