package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private People people;
    private List<Line> lines;

    private Ladder(String names, int length) {
        createPeople(names);
        createLines(names, length);
    }

    private Ladder(String names, List<Line> lines) {
        createPeople(names);
        this.lines = lines;
    }

    public static Ladder of(String names, int length) {
        return new Ladder(names, length);
    }

    public static Ladder of(String names, List<Line> lines) {
        return new Ladder(names, lines);
    }

    public People getPeople() {
        return people;
    }

    public List<Line> getLines() {
        return lines;
    }

    private void createPeople(String names) {
        this.people = People.of(names);
    }

    private void createLines(String person, int length) {
        this.lines = new ArrayList<>();

        for(int i = 0; i < length; i++) {
            int countOfPerson = person.split(",").length;
            this.lines.add(Line.of(countOfPerson));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ladder ladder = (Ladder) o;

        if (people != null ? !people.equals(ladder.people) : ladder.people != null) return false;
        return lines != null ? lines.equals(ladder.lines) : ladder.lines == null;
    }

    @Override
    public int hashCode() {
        int result = people != null ? people.hashCode() : 0;
        result = 31 * result + (lines != null ? lines.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "people=" + people +
                ", lines=" + lines +
                '}';
    }
}

