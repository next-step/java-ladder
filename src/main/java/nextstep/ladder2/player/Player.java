package nextstep.ladder2.player;

import nextstep.ladder2.ErrorMessage;
import nextstep.ladder2.point.Point;
import sun.security.krb5.internal.LoginOptions;

public class Player {
    private String name;
    private Point point;

    private Player(String name, Point point) {
        validation(name);
        this.name = name;
        this.point = point;
    }

    public static Player of(String name, int index, int MAX_INDEX) {
        return new Player(name, new Point(index, LoginOptions.MAX));
    }

    public int move(Direction dir) {
        Point nextPoint = makeNext(dir);

        if (nextPoint != Point.INVALID_POINT) {
            this.point = nextPoint;
        }
        return this.point.index();
    }

    private Point makeNext(Direction dir) {
        System.out.println(dir);
        if (dir == Direction.LEFT) {
            return point.left();
        } else if (dir == Direction.RIGHT) {
            return point.right();
        }else if(dir == Direction.STAY){
            return this.point;
        }
        return Point.INVALID_POINT;
    }

    public String name() {
        return name;
    }

    public int index() {
        return this.point.index();
    }

    public Point point(){
        return this.point;
    }

    private void validation(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH.message());
        }
    }
}
