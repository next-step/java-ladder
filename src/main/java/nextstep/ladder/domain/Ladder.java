package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Lines> linesList;

    private Ladder(List<Lines> linesList) {
        this.linesList = linesList;
    }

    private static Ladder of(List<Lines> linesList) {
        return new Ladder(linesList);
    }

    public static Ladder makeLadder(int nameSize, int maxLadderHeight) {
        List<Lines> linesList = new ArrayList<>();

        for (int i = 0; i < maxLadderHeight; i++) {
            linesList.add(Lines.of(nameSize, new RandomCreationStrategy()));
        }
        return of(linesList);
    }

    public List<Lines> getLinesList() {
        return linesList;
    }

    public int findLocation(int positionNumber) {
        int startNumber = positionNumber;

        for (Lines lines : linesList) {
            Position position = Position.of(startNumber, lines);
            position.move();
            startNumber = position.getPosition();
        }

        return startNumber;
    }
}
