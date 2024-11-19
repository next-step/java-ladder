package nextstep.ladder;


public class Line {
    private Points points;

    public Line(int countOfPerson) {
        points = new Points(countOfPerson);
    }

    public Line(Points points) {
        this.points = points;
    }

    public String toString(String trueSymbol, String falseSymbol) {
        return points.toString(trueSymbol, falseSymbol);
    }

    public Integer getResultIndex(int index) {
        return points.getResultIndex(index);
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
