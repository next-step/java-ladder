package nextstep.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static nextstep.ladder.RandomRungGenerator.generate;

public class Line {
    private final int countOfPeople; //todo : countOfPeople 유효성검사
    private final List<Rung> rungs; //todo: rungs 일급컬렉션

    public Line(int countOfPeople) {
        this(countOfPeople, new ArrayList<>());
    }

    public Line(int countOfPeople, List<Rung> rungs) {
        this.countOfPeople = countOfPeople;
        this.rungs = rungs;
    }

    public List<Rung> create() {
        Rung rung = Rung.first(generate());
        rungs.add(rung);

        while (rung.isInLadderRange(countOfPeople)) {
            rung = rung.next();
            rungs.add(rung);
        }

        rungs.add(rung.last());

        return Collections.unmodifiableList(rungs);
    }

    public int move(int position) {
        return rungs.get(position).move();
    }
}
