package nextstep.ladder.domain;

import nextstep.ladder.utils.LadderGenerator;

import java.util.List;

public class Line {

    private final Rungs rungs;

    public Line(int countOfPerson, LadderGenerator generator) {
        this(new CountOfPerson(countOfPerson), generator);
    }

    public Line(CountOfPerson countOfPerson, LadderGenerator generator) {
        rungs = new Rungs(countOfPerson, generator);
    }

    public int size() {
        return rungs.size();
    }

    public List<Rung> getRungs() {
        return rungs.getRungs();
    }

    public List<Boolean> validateLine() {
        return rungs.validateRungs();
    }
}
