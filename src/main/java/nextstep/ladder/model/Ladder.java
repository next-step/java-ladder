package nextstep.ladder.model;

import java.util.ArrayList;
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

    public int peopleCount() {
        return this.people.count();
    }

    public String personName(int index) {
        return people.name(index);
    }

    public int height() {
        return this.lines.height();
    }


    public List<Boolean> horizonLineDrawAvailable(int index) {
        return this.lines.horizonLineDrawAvailable(index);
    }

    public List<Integer> finalPeopleArrived() {
        List<Integer> arrived = new ArrayList<>();
        for (int startIndex = 0; startIndex < lines.lineCount(); startIndex++) {
            arrived.add(lines.move(0, startIndex));
        }
        return arrived;
    }
}
