package nextstep.step2.VO;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public Position moveToLeft() {
        return new Position(this.position --) ;
    }

    public Position moveToDown() {
        return new Position(this.position) ;
    }

    public Position moveToRight() {
        return new Position(this.position ++) ;
    }
}
