package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines = new ArrayList<>();

    public Lines(List<Line> lines) {
        validateLines(lines);
        this.lines.addAll(lines);
    }

    public static Lines from(List<Line> lines) {
        return new Lines(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getHeight() {
        return lines.get(0).getHeight();
    }

    public int getWidth() {
        return lines.size();
    }

    public boolean existsBridge(int idx, int h) {
        return lines.get(idx).getBridgeByIdx(h - 1).isOpen();
    }

    private void validateLines(List<Line> lines) {
        validateHeightSame(lines);
        validateFirstLineIsAllClosed(lines);
        validateDuplicatedBridge(lines);
    }

    private void validateHeightSame(List<Line> lines) {
        int height = lines.get(0).getHeight();
        IntStream.range(1, lines.size())
            .filter(idx -> !lines.get(idx).isEqualsHeight(height))
            .findAny()
            .ifPresent(l -> {
                throw new IllegalArgumentException("lines의 높이는 모두 같아야합니다.");
            });
    }

    private void validateFirstLineIsAllClosed(List<Line> lines) {
        lines.get(0).getBridges().stream()
            .filter(Bridge::isOpen)
            .findAny()
            .ifPresent(b -> {
                throw new IllegalArgumentException("첫번째 Line의 Bridges는 모두 닫혀있어야합니다.");
            });
    }

    private void validateDuplicatedBridge(List<Line> lines) {
        IntStream.range(1, lines.size())
            .filter(idx -> lines.get(idx).isDuplicatedLine(lines.get(idx - 1)))
            .findAny()
            .ifPresent(i -> {
                throw new IllegalArgumentException("line의 양쪽 Bridge는 모두 열려있을 수 없습니다.");
            });
    }
}
