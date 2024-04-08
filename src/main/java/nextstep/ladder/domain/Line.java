package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<LinePoint> line;
    private final LineLength length;

    public Line(int lineLength, LineGenerator lineGenerator) {
        this.length = new LineLength(lineLength);
        this.line = lineGenerator.generate(this.length);
        assertValidLine(this.line);
    }


    public int nextIndex(int index) {
        LinePoint linePoint = line.get(index);
        if (linePoint.canMoveLeft()) {
            return index - 1;
        }
        if (linePoint.canMoveRight()) {
            return index + 1;
        }

        return index;
    }

    private void assertValidLine(List<LinePoint> line) {
        String errorMessage = "[라인] 시작 점은 왼쪽으로 갈 수 없고, 끝 점은 오른쪽으로 갈 수 없습니다.";
        if (line.get(0).canMoveLeft() || line.get(line.size() - 1).canMoveRight()) {
            throw new IllegalArgumentException(errorMessage);
        }

        for (int i = 1; i < line.size(); i++) {
            assertValidLinePoints(line.get(i - 1), line.get(i));
        }
    }

    private void assertValidLinePoints(LinePoint previous, LinePoint current) {
        String errorMessage = "[라인] 라인이 잘못 이어져있습니다.";
        if (previous.canMoveRight() && !current.canMoveLeft()) {
            throw new IllegalArgumentException(errorMessage);
        }
        if (!previous.canMoveRight() && current.canMoveLeft()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public List<LinePoint> getLine() {
        return line.stream().collect(Collectors.toUnmodifiableList());
    }

    public int getLength() {
        return length.getLength();
    }
}
