package ladder.model.name.wrapper;

import ladder.model.ladder.Bridge;
import ladder.model.move.Point;
import ladder.model.name.Name;

public class User {
    private Name name;
    private Point point;

    private User(String name, int x){
        this.name = Name.createUserName(name);
        this.point = Point.userPoint(x);
    }

    public static User of(String name, int x){
        return new User(name, x);
    }

    public boolean isCross(Bridge bridge){
        return bridge.isCross(point) && bridge.isMovable();
    }

    public Point getPoint(){
        return point;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
