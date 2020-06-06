package ladder.domain;

public class Ladder {
    private final int countOfPerson;
    private final int ladderHeight;

    public Ladder(int countOfPerson,int ladderHeight) {
        this.countOfPerson = countOfPerson;
        this.ladderHeight = ladderHeight;
    }

    public LineList createLadder() {
        LineList lineList = new LineList();
        for (int idx = 0; idx < ladderHeight; idx++) {
            lineList.createLine(countOfPerson);
        }
        return lineList;
    }

}
