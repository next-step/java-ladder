package Ladder;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private List<LadderLine> lines = new ArrayList<>();
    private Persons persons;

    public Lines(Persons persons, int height) {
        this.persons = persons;

        for (int i = 0; i < height; i++) {
            LadderLine line = LadderLine.init(persons.personCount());
            lines.add(line);
        }
    }

    public int totalLineNum() {
        return lines.size();
    }

    public LadderLine getOneLine(int lineNumber) {
        return lines.get(lineNumber);
    }

    @Override
    public String toString() {
        StringBuilder ladder = new StringBuilder();
        ladder.append(persons.toString() + "\n");
        for (int i = 0; i < lines.size(); i++) {
            ladder.append(getOneLine(i).toString() + "\n");
        }
        return ladder.toString();
    }
}
