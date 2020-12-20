package nextstep.step2.VO;

public class Position {
    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public Position moveToLeft() {
        int newPosition = this.position - 1;
        return new Position(newPosition) ;
    }

    public Position moveToDown() {
        return new Position(this.position) ;
    }

    public Position moveToRight() {
        int newPosition = this.position + 1;
        return new Position(newPosition) ;
    }
}
