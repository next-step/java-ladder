package nextstep.ladder;

public class Line {
    private final Points points;

    public Line(CountOfPerson countOfPerson) {
        points = new Points(countOfPerson);
    }
}
