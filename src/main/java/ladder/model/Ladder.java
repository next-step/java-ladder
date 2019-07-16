package ladder.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Ladder {

    private static final Logger logger = LoggerFactory.getLogger(Ladder.class);
    private final List<LadderLine> ladder;

    public Ladder(List<LadderLine> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(int userCount, String ladderHeight) {
        List<LadderLine> ladder = new ArrayList <>();
        for (int i = 0; i < validationNumberFormat(ladderHeight); i++) {
            ladder.add(createLine(userCount));
        }
        return new Ladder(ladder);
    }

    public int ladderRid(int userIndex) {
        int userPosition = userIndex;
        for (LadderLine ladderLine : ladder) {
            userPosition = ladderLine.move(userPosition);
        }
        return userPosition;
    }

    private static int validationNumberFormat(String ladderHeight) {

        try {
            return Integer.parseInt(ladderHeight);
        } catch (NumberFormatException numberFomatException) {
            logger.error("number format exception = {}", "validation ladderHeight");
            throw new NumberFormatException("최대 사다리 높이는 숫자만 입력 할 수 있습니다.");
        }
    }

    private static LadderLine createLine(int userCount) {
        return LadderLine.lineSet(userCount);
    }

    public List<LadderLine> getLadder() {
        return Collections.unmodifiableList(this.ladder);
    }

}
