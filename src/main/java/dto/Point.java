package dto;

public class Point {

    private int index;
    private Direction direction;

    public Point(int index,Direction direction) {
        if(index < 0){
            throw new IllegalArgumentException();
        }
        this.index = index;
        this.direction = direction;
    }

    public static Point isFirst(Mode mode){
        return new Point(0,Direction.find(false,Mode.drawLineByPercentage(mode)));
    }

    public static Point isNext(Point before, Mode mode){
        return new Point(before.nextIndex(),Direction.next(before.direction.isRight() , mode));
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



    /**
     * move logic
     */
    public int move(){
        if(this.direction.isLeft()){
            return this.index -1;
        }
        if(this.direction.isRight()){
            return this.index +1;
        }
        return this.index;
    }

}
