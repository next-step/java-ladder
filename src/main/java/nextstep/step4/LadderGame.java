package nextstep.step4;

import java.util.List;

import static nextstep.ladder.CommonConstans.COMMON_ENTER;

public class LadderGame {

    private int numberOfPerson;
    private List<LadderLine> ladderLines;

    public LadderGame(int numberOfPerson, List<LadderLine> ladderLines) {
        this.numberOfPerson = numberOfPerson;
        this.ladderLines = ladderLines;
    }

    public static LadderGame of(int numberOfPerson, List<LadderLine> ladderLines) {
        return new LadderGame(numberOfPerson, ladderLines);
    }

    public String drawLadderLines() {
        String laderLines = "";

        for (LadderLine ladderLine : ladderLines) {
            laderLines += ladderLine.drawLine() + COMMON_ENTER;
        }

        return laderLines;
    }

    public LadderResult playLadder() {
        LadderResult ladderResult = new LadderResult();

        for (int i = 0; i < numberOfPerson; i++) {
            ladderResult.put(i, getArrive(i));
        }

        return ladderResult;
    }

    private int getArrive(int position) {
        int arrivePosition = position;
        for (LadderLine ladderLine : ladderLines) {
            arrivePosition = ladderLine.move(arrivePosition);
        }
        return arrivePosition;
    }
}
