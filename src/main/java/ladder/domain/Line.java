package ladder.domain;

import java.util.List;

public class Line {
    private static final String LADDER_LINE = "|";
    private Points points;

    public Line(int countOfPerson) {
        this.points = new Points(countOfPerson, new PointsShuffleGenerator());
    }


    public void test() {
        List<Boolean> ladderPoints = this.points.getPoints();
        for (Boolean ladderPoint : ladderPoints) {
            if (ladderPoint) {
                System.out.print(LADDER_LINE + "-----");
            } else {
                System.out.print(LADDER_LINE + "     ");
            }
        }
        System.out.print(LADDER_LINE);
    }

}
