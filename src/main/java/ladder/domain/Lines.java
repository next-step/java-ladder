package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private List<Line> lines = new ArrayList<>();
    private final People people;

    public Lines(int countOfLine, String names) {
        this.people = new People(names);
        int countOfPerson = people.getPeople()
                .size();
        this.lines = createLines(countOfLine, new LineShuffleGenerator(countOfPerson));
    }

    private List<Line> createLines(int countOfLine, LineGenerator lineGenerator) {
        for (int i = 0; i < countOfLine; i++) {
            this.lines.add(lineGenerator.generate());
        }
        return new ArrayList<>(lines);
    }

    public List<Line> getLadderLines() {
        return new ArrayList<>(lines);
    }

    public List<String> getPeople() {
        return new ArrayList<>(people.getPeople());
    }
}
