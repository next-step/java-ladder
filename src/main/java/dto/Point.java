package dto;

import java.util.Random;

public class Point {

    int index;
    Direction direction;

    public Point(int index,Direction direction) {
        if(index < 0){
            throw new IllegalArgumentException();
        }
        this.index = index;
        this.direction = direction;
    }

    public static Point isFirst(){
        return new Point(0,Direction.find(false,new Random().nextBoolean()));
    }

    public static Point isNext(Point before){
        return new Point(before.nextIndex(),Direction.next(before.direction.isRight()));
    }

    public static Point isLast(Point before){
        return new Point(before.nextIndex(),Direction.find(before.direction.isRight(),false));
    }

    private int nextIndex(){
        return this.index + 1;
    }

    @Override
    public String toString() {
        return "index :" + index + "Diretction : " + direction;
    }

    public Direction getDirection() {
        return direction;
    }
}
