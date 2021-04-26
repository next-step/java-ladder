package step02.ladder;

import step02.exception.ZeroHeightException;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final static String ERROR_ZERO_LINE = "사다리는 높이 0이상으로 입력해주세요.";
    private final static int ZERO = 0;

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int xCount, int yCount, LineStrategy lineStrategy) throws ZeroHeightException {
        checkZeroLine(yCount);

        for (int i = 0; i < yCount; i++) {
            lines.add(new Line(xCount, lineStrategy));
        }
    }

    private void checkZeroLine(int height) throws ZeroHeightException {
        if (height <= ZERO) {
            throw new ZeroHeightException(ERROR_ZERO_LINE);
        }
    }

    public int getYLineCount() {
        return lines.size();
    }

    public List<Line> getLadderLine() {
        return lines;
    }
}

