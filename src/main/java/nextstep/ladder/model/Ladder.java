package nextstep.ladder.model;

import java.util.List;

public class Ladder {
    private final People people;
    private final Lines lines;

    public Ladder(People people, Lines lines) {
        this.people = people;
        this.lines = lines;
    }

    public List<String> peopleNames() {
        return this.people.names();
    }

    public int height() {
        return this.lines.height();
    }

    public int peopleCount() {
        return this.people.count();
    }

    public List<Boolean> horizonLineDrawAvailable(int index) {
        return this.lines.horizonLineDrawAvailable(index);
    }
}
