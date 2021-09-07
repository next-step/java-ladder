package nextstep.ladder2.player;

import nextstep.ladder2.point.LadderPoint;
import nextstep.ladder2.point.Point;

public class Player {
    private String name;
    private Point point;

    public Player(String name, int point, int MAX_INDEX) {
        this.name = name;
        this.point = new Point(point, MAX_INDEX);
    }

    public LadderPoint ladderPoint(){
        return new LadderPoint(point);
    }
}
