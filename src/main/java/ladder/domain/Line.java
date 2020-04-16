package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final String WIDTH_REQUIRED = "가로라인이 존재해야합니다.";
    private static final int MINIMUM_USERS = 2;
    private static final String USER_SHOULD_MORE_THAN_TWO = "사람수는 2명 이상 이어야 합니다.";
    private final List<Boolean> widthLines;

    public Line(List<Boolean> width) {
        this.widthLines = validateLines(width);
    }

    public Line(final int countOfPerson) {
        this(countOfPerson, new WidthGenerator(countOfPerson));
    }

    public Line(final int countOfPerson, WidthGenerator subLineGenerator) {
        validateSize(countOfPerson);
        this.widthLines = new ArrayList<>(validateLines(subLineGenerator.getWidthLines()));
    }

    private void validateSize(int users) {
        if (users < MINIMUM_USERS) {
            throw new IllegalArgumentException(USER_SHOULD_MORE_THAN_TWO);
        }
    }

    private List<Boolean> validateLines(List<Boolean> widthLines) {
        if (widthLines.isEmpty()) {
            throw new IllegalArgumentException(WIDTH_REQUIRED);
        }
        return new ArrayList<>(widthLines);
    }

    public List<Boolean> getWidthLines() {
        return widthLines;
    }

    public int move(int index) {
        if (isLeft(index)) {
            return -1;
        }
        if (isRight(index)) {
            return 1;
        }
        return 0;
    }

    private boolean isLeft(int index) {
        return index > 0 && widthLines.get(index - 1);
    }

    private boolean isRight(int index) {
        return index < widthLines.size() && widthLines.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(widthLines, line.widthLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(widthLines);
    }
}
