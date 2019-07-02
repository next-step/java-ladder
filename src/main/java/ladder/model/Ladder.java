package ladder.model;

import ladder.enumSet.Validation;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> ladder = new ArrayList <>();

    public Ladder(int userCount, String ladderHeight) {
        int height = numberValidation(ladderHeight);
        for (int i = 0; i < height; i++) {
            ladder.add(createLine(userCount));
        }
    }

    public List<Line> getLadder() {
        return this.ladder;
    }

    private int numberValidation(String ladderHeight) {
        if (Validation.LADDER_HEIGHT_VALIDATE.isInValid(ladderHeight)) {
            throw new NumberFormatException("최대 사다리 높이는 숫자만 입력 할 수 있습니다.");
        }
        return Integer.parseInt(ladderHeight);
    }

    private Line createLine(int userCount) {
        return new Line(userCount);
    }

}
