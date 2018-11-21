package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private People people;
    private List<Line> lines;

    private Ladder(String names, List<Line> lines) {
        this.people = People.of(names);
        this.lines = lines;
    }

    public static Ladder of(String names, int length) {
        List<Line> lines = new ArrayList<>();

        for(int i = 0; i < length; i++) {
            int countOfPerson = names.split(",").length;
            lines.add(Line.of(countOfPerson));
        }
        return new Ladder(names, lines);
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

