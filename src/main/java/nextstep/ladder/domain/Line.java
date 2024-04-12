package nextstep.ladder.domain;

import nextstep.ladder.utils.LadderGenerator;

import java.util.List;

public class Line {

    private final Points points;

    public Line(int countOfPerson, LadderGenerator generator) {
        this(new CountOfPerson(countOfPerson), generator);
    }

    public Line(CountOfPerson countOfPerson, LadderGenerator generator) {
        points = new Points(countOfPerson, generator);
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return points.getPoints();
    }

    public List<Boolean> validateLine() {
        return points.validatePoints();
    }
}
