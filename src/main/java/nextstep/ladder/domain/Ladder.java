package nextstep.ladder.domain;

public class Ladder {

    private final LadderInOut ladderInOut;
    private final LadderLine line;

    public Ladder(LadderInOut ladderInOut, LadderLine line) {
        this.ladderInOut = ladderInOut;
        this.line = line;
    }

    public String getResultName(int idx) {
        return ladderInOut.getResult(idx);
    }

    public String getResult(int userIdx) {
        int arriveIdx = line.getArriveIdx(userIdx);
        return ladderInOut.getResult(arriveIdx);
    }

    public String getResult(String name) {
        int userIdx = ladderInOut.indexOfUser(name);
        int arriveIdx = line.getArriveIdx(userIdx);
        return ladderInOut.getResult(arriveIdx);
    }

    public int getCountOfPerson() {
        return ladderInOut.getCountOfUser();
    }

    public Line getLine(int idx) {
        return line.getLine(idx);
    }

    public String getUserName(int idx) {
        return ladderInOut.getUserName(idx);
    }

    public int getHeight() {
        return line.getHeight();
    }
}
