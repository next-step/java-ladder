package ladder.domain.ladder;

import ladder.domain.player.People;
import ladder.domain.player.Person;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private int height;
    private List<Line> lines;

    public Ladder(int height) {
        this.height = height;
        lines = new ArrayList<>();
    }

    public List<Line> generateLadder() {
        for (int i = 0; i < height; i++) {
            lines.add(new Line());
        }
        return lines;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Line line : lines) {
            stringBuilder.append("|");
            stringBuilder.append(line.toString()+"\n");
        }
        return stringBuilder.toString();
    }

    public Integer getResult(People people, int personPosition) {

        for (Line line : lines) {
            personPosition = line.findNextStep(personPosition);
        }

        return personPosition;
    }

    public void makeLadderLines(People people) {
        for (Line line : lines) {
            line.makeLineLadderPoints(people);
        }
    }
}
