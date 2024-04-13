package nextstep.ladder.domain;

import nextstep.ladder.utils.LadderGenerator;

import java.util.ArrayList;
import java.util.List;

public class Rungs {

    private final List<Rung> rungs = new ArrayList<>();

    public Rungs(int countOfPerson, LadderGenerator strategy) {
        this(new CountOfPerson(countOfPerson), strategy);
    }

    public Rungs(CountOfPerson countOfPerson, LadderGenerator strategy) {
        countOfPerson.rangOfZeroToCount()
                .forEach(i -> {
            boolean hasLadder = strategy.generate();
            if (isNotFirstPoint(i) && hasLadderAtPrevious(i).isExist()) {
                hasLadder = false;
            }
            addLadderPoints(new Rung(hasLadder));
        });
    }

    public Rungs(List<Rung> rungs) {
        this.rungs.addAll(rungs);
    }

    private boolean isNotFirstPoint(int i) {
        return i >= 1;
    }

    private Rung hasLadderAtPrevious(int i) {
        return rungs.get(i - 1);
    }

    private void addLadderPoints(Rung rung) {
        rungs.add(rung);
    }

    public int size() {
        return rungs.size();
    }

    public boolean isExist(int index) {
        return rungs.get(index).isExist();
    }

    public List<Rung> getPoints() {
        return rungs;
    }

    public List<Boolean> validatePoints() {
        List<Boolean> booleans = new ArrayList<>();
        for (Rung rung : rungs) {
            booleans.add(rung.isExist());
        }
        return booleans;
    }

}
