package nextstep.ladder.domain;

import nextstep.ladder.utils.RandomLadderGenerator;

import java.util.List;

public class Line {

    private final Points points;

    public Line(int countOfPerson) {
        this(new CountOfPerson(countOfPerson));
    }

    public Line(CountOfPerson countOfPerson) {
        points = new Points(countOfPerson, new RandomLadderGenerator());
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points.getPoints();
    }

}
