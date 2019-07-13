package ladder.model;

public class Point {

    private final StatusOfPoint statusOfPoint;
    private final int idx;

    public Point(int idx, StatusOfPoint statusOfPoint) {
        this.idx = idx;
        this.statusOfPoint = statusOfPoint;
    }

    public int move() {
        System.out.println("is left? " + statusOfPoint.isLeft());
        System.out.println("is right? " + statusOfPoint.isRight());

        if(statusOfPoint.isLeft()){
            return moveLeft();
        }
        if(statusOfPoint.isRight()){
            return moveRight();
        }
        return idx;
    }

    public static Point first(boolean right){
        return new Point(0, StatusOfPoint.first(right));
    }

    public Point next(){
        return new Point(idx + 1, statusOfPoint.next());
    }

    public Point next(Boolean right) {
        return new Point(idx + 1, statusOfPoint.next(right));
    }

    public Point last(){
        return new Point(idx + 1, statusOfPoint.last());
    }

    private int moveLeft(){
        if(idx - 1 < 0){
            throw new IllegalStateException("더 이상 왼쪽으로 이동 할 수 없습니다.");
        }
        return idx - 1;
    }

    private int moveRight(){
        return idx + 1;
    }

    public StatusOfPoint getStatusOfPoint() {
        return this.statusOfPoint;
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + idx +
                ", direction=" + statusOfPoint +
                '}';
    }

}
