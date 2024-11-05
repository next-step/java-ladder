package nextstep.ladder;


public class Line {
    private Points points;

    public Line(int countOfPerson) {
        points = new Points(countOfPerson);
    }

    public String toString(String trueSymbol, String falseSymbol) {
        return points.toString(trueSymbol, falseSymbol);
    }

}
