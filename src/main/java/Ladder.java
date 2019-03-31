import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        verifyHeightOfLadder(lines);
        verifyCountOfPointOfAllLines(lines);
        this.lines = lines;
    }

    private void verifyCountOfPointOfAllLines(List<Line> lines) {
        Line firstLine = lines.get(0);
        if(!isAllMatchCountOfPoint(lines, firstLine)) {
            throw new IllegalArgumentException("모든 라인의 포인트 개수는 동일해야 합니다.");
        }
    }

    private boolean isAllMatchCountOfPoint(List<Line> lines, Line firstLine) {
        return lines.stream().allMatch(line -> line.matchCountOfPoint(firstLine));
    }

    private void verifyHeightOfLadder(List<Line> lines) {
        if(lines.size() < 1) {
            throw new IllegalArgumentException("높이가 1미만인 사다리는 생성할 수 없습니다.");
        }
    }

    public int getNumberOfLines() {
        return lines.size();
    }

    public int getCountOfPoints() {
        return lines.get(0).getNumberOfPoints();
    }
}
