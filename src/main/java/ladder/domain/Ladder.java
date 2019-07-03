package ladder.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Ladder {
    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final int MIN_LADDER_HEIGHT = 1;
    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder newLadder(int countOfGamer, String inputHeight) throws IllegalArgumentException {
        if (StringUtils.isBlank(inputHeight) || !Pattern.matches(NUMBER_REGEX, inputHeight)) {
            throw new IllegalArgumentException("숫자형태 문자열이 와야 할 자리에 다른형태 문자열이 있습니다.");
        }
        int ladderHeight = Integer.parseInt(inputHeight);
        if (MIN_LADDER_HEIGHT > ladderHeight) {
            throw new IllegalArgumentException("사다리 높이는 최소 1 이상입니다.");
        }

        List<Line> lines = new ArrayList<>();
        for (int index = 0; index < ladderHeight; index++) {
            lines.add(Line.countGamerOf(countOfGamer));
        }

        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
