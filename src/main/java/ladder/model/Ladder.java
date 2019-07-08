package ladder.model;

import ladder.enumset.Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> ladder = new ArrayList <>();
    private final int ladderHeight;
    public Ladder(int userCount, String ladderHeight) {
        this.ladderHeight = numberValidation(ladderHeight);
        for (int i = 0; i < this.ladderHeight; i++) {
            ladder.add(createLine(userCount));
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(this.ladder);
    }

    public int ladderRiding(int userIndex) {
        int userPosition = userIndex;
        for(Line line : ladder){
            Point point = line.getPoints().get(userPosition);
            userPosition = point.move();
        }
        return userPosition;
    }

    private int numberValidation(String ladderHeight) {
        if (Validation.LADDER_HEIGHT_VALIDATE.isInValid(ladderHeight)) {
            throw new NumberFormatException("최대 사다리 높이는 숫자만 입력 할 수 있습니다.");
        }
        return Integer.parseInt(ladderHeight);
    }

    private Line createLine(int userCount) {
        return Line.lineSet(userCount);
    }
}
