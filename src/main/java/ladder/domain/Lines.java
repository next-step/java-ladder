package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lines {
    private static final String DELIMITER = ",";
    private List<Line> lines;
    private String[] persons;

    public Lines(int countOfLine, int countOfPerson) {
        lines = createLines(countOfLine, countOfPerson);
    }

    public Lines(int countOfLine, String person) {
        this.persons = person.split(DELIMITER);
        lines = createLines(countOfLine, persons.length);
    }

    public List<Line> createLines(int countOfLine, int countOfPerson) {
        lines = new ArrayList<>();
        for (int i = 0; i < countOfLine; i++) {
            Line line = new Line(countOfPerson);
            lines.add(line);
        }
        return new ArrayList<>(lines);
    }

    public List<Line> getLadderLines() {
        return new ArrayList<>(lines);
    }

    public List<String> getPersons() {
        return Arrays.asList(persons);
    }
}
