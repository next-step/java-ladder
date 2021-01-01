package nextstep.ladder.model;

import java.util.*;

public class Ladder {
    private final List<LadderLine> lines;
    private Map<Person, Result> matches;


    public Ladder(int countOfPerson, int height) {
        lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(LadderLine.init(countOfPerson));
        }

    }

    public List<LadderLine> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public Map<Person, Result> getPersonResult(List<Person> people, List<Result> results) {
        matches = new HashMap<>();
        people.get(0);
        results.get(0);
        for (int i = 0; i < people.size(); i++) {
            matches.put(people.get(i), results.get(move(i)));
        }
        return Collections.unmodifiableMap(matches);
    }

    public int move(int position) {
        int result = position;
        for (LadderLine line : lines) {
            result = line.move(result);
        }
        return result;
    }

}
