package nextstep.ladder.domain;

public class Ladder {

    private final LadderInput ladderInput;
    private final LadderLine line;

    public Ladder(LadderInput ladderInput, LadderLine line) {
        this.ladderInput = ladderInput;
        this.line = line;
    }

    public String getResultName(int idx) {
        return ladderInput.getResult(idx);
    }

    public String getResult(int userIdx) {
        int arriveIdx = line.getArriveIdx(userIdx);
        return ladderInput.getResult(arriveIdx);
    }

    public String getResult(String name) {
        int userIdx = ladderInput.indexOfUser(name);
        int arriveIdx = line.getArriveIdx(userIdx);
        return ladderInput.getResult(arriveIdx);
    }

    public int getCountOfPerson() {
        return ladderInput.getCountOfUser();
    }

    public Line getLine(int idx) {
        return line.getLine(idx);
    }

    public String getUserName(int idx) {
        return ladderInput.getUserName(idx);
    }

    public int getHeight() {
        return line.getHeight();
    }
}
