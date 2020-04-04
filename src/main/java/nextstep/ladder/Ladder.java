package nextstep.ladder;

import java.util.List;

public class Ladder {
    public static final String LADDER_HEIGHT_ERROR = "사다리 높이는 1보다 커야합니다.";

    private List<Line> lines;
    public Ladder(List<Line> lines) {
        assertLadderHeight(lines.size());
        this.lines = lines;
    }

    private void assertLadderHeight(int height) {
        if(height < 1) {
            throw new IllegalArgumentException(LADDER_HEIGHT_ERROR);
        }
    }

    public int getWidth() {
        return lines.get(0).getValue().size();
    }

    public int getHeight() {
        return lines.size();
    }
}
