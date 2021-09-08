package nextstep.ladder2.player;

import nextstep.ladder2.ErrorMessage;
import nextstep.ladder2.point.Point;

public class Player {
    private String name;
    private Point point;

    public Player(String name, Point point) {
        validation(name);
        this.name = name;
        this.point = point;
    }

    public void move(Direction dir){
        if(dir==Direction.LEFT){
            point = point.left();
        }else if(dir==Direction.RIGHT){
            point = point.right();
        }
    }

    public String name(){
        return name;
    }

    public Point position(){
        return this.point;
    }

    private void validation(String name){
        if(name.length()>5){
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH.message());
        }
    }
}
