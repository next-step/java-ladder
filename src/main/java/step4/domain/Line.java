package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {

    private final List<Bridge> bridges = new ArrayList<>();
    private final Height height;

    public Line(List<Bridge> bridges, Height height) {
        if (!height.isSame(bridges.size())) {
            throw new IllegalArgumentException("라인의 높이와, Bridges의 개수는 동일해야합니다.");
        }
        this.bridges.addAll(bridges);
        this.height = height;
    }

    public static Line from(List<Bridge> bridges) {
        return new Line(bridges, new Height(bridges.size()));
    }

    public int getHeight() {
        return height.getHeight();
    }

    public boolean isEqualsHeight(int height) {
        return this.height.isSame(height);
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }

    public Bridge getBridgeByIdx(int idx) {
        return bridges.get(idx);
    }

    public boolean isDuplicatedLine(Line beforeLine) {
        return IntStream.range(0, getHeight())
            .anyMatch(idx ->
                beforeLine.getBridgeByIdx(idx).isDuplicatedBridge(getBridgeByIdx(idx))
            );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Line)) {
            return false;
        }

        Line line = (Line) o;

        if (!bridges.equals(line.bridges)) {
            return false;
        }
        return Objects.equals(height, line.height);
    }

    @Override
    public int hashCode() {
        int result = bridges.hashCode();
        result = 31 * result + (height != null ? height.hashCode() : 0);
        return result;
    }
}
