package ladder.domain;

public class Point {
    //    private Boolean point;
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

//    public Point(boolean point) {
//        this.point = point;
//    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public int move() {
//        System.out.println("is left? " + direction.isLeft());
//        System.out.println("is right? " + direction.isRight());

        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return this.index;
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }


//    public Boolean getPoint() {
//        return point;
//    }
//
//    public Point checkDuplicate(Point next){
//        if(this.point== Boolean.TRUE && this.point.equals(next.point))
//            return new Point(false);
//        return next;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return true;
    }
}
