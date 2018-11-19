package ladder.domain;

import java.util.ArrayList;

public class Ladder {

    private int height;
    private ArrayList<Line> lines;

    public Ladder(int height) {
        this.height = height;
        lines = new ArrayList<>();
    }

    public ArrayList<Line> generateLadder(People people) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(people));
        }
        return lines;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Line line : lines) {
            stringBuilder.append(line.toString()+"\n");
        }
        return stringBuilder.toString();
    }

    public Person getResult(Person person) {

        for (Line line : lines) {
            person = line.findNextStep(person);
        }

        return person;
    }
}
