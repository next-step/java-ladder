package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {


    private List<String> users;
    private List<Line> lines = new ArrayList<>();
    private int height;

    public Ladder(List<String> users, int height) {
        this.users = users;
        this.height = height;
    }

    public List<Line> createAllLines(List<Integer> beforeNumbers, int start, int width) {
        List<Line> lines = new ArrayList<>();
        for (int i = start; i <= width; i++) {
            createSeperateNumbers(beforeNumbers, lines, i);
            List<Integer> numbers = new ArrayList<>(beforeNumbers);
            numbers.add(i);
            lines.addAll(createAllLines(numbers, i + 2, width));
        }

        return lines;
    }

    private void createSeperateNumbers(List<Integer> beforeNumbers, List<Line> lines, int i) {
        List<Integer> numbers = new ArrayList<>(beforeNumbers);
        numbers.add(i);
        lines.add(new Line(numbers));
    }

    public List<String> getUsers() {
        return users;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return height;
    }

    public void createLines(List<Line> randomLine) {
        lines.addAll(randomLine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return height == ladder.height &&
                Objects.equals(users, ladder.users) &&
                Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users, lines, height);
    }
}
