package nextstep.ladder;

public class Cross {
    private int position;
    private Point point;

    public Cross(int position, Point point) {
        this.position = position;
        this.point = point;
    }

    public int move() {
        if(point.move() == Direction.RIGHT) {
            return position + 1;
        } else if(point.move() == Direction.LEFT) {
            return position - 1;
        }

        return position;
    }

    public String getCrossForPrint(String trueSymbol, String falseSymbol) {
        if(point.move() == Direction.RIGHT) {
            return trueSymbol;
        }

        return falseSymbol;
    }

}
