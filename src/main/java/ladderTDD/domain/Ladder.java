package ladderTDD.domain;

import ladderTDD.player.People;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int DEFAULT_ZERO = 0;
    private List<LadderLine> lines;

    private Ladder(List<LadderLine> ladderLines) {
        this.lines = ladderLines;
    }

    public static Ladder initLadder(int height, People people) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = DEFAULT_ZERO; i < height; i++) {
            ladderLines.add(LadderLine.init(people.peopleCount()));
        }
        return new Ladder(ladderLines);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (LadderLine line : lines) {
            stringBuilder.append("|");
            stringBuilder.append(line.toString()+"\n");
        }
        return stringBuilder.toString();
    }

    public Integer getResult(int personPosition) {
        for (LadderLine line : lines) {
            personPosition = line.move(personPosition);
        }

        return personPosition;
    }
}
