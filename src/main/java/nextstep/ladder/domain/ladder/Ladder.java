package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Ladder fail. " +
            "gamers must be at least %d and" +
            "height must be at least %d : sizeOfPerson=%d, height=%d";
    private static int MINIMUM_PERSON_SIZE = 2;
    private static int MINIMUM_HEIGHT = 1;

    private final List<LadderLine> ladderLines;
    private final int sizeOfPerson;

    private Ladder(List<LadderLine> ladderLines, int sizeOfPerson) {
        this.ladderLines = Collections.unmodifiableList(ladderLines);
        this.sizeOfPerson = sizeOfPerson;
    }

    public static Ladder of(int sizeOfPerson, int height) {
        if (isInvalid(sizeOfPerson, height)) {
            throw new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, MINIMUM_PERSON_SIZE, MINIMUM_HEIGHT, sizeOfPerson, height));
        }
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderLines.add(LadderLine.init(sizeOfPerson));
        }
        return new Ladder(ladderLines, sizeOfPerson);
    }

    private static boolean isInvalid(int sizeOfPerson, int height) {
        return sizeOfPerson < MINIMUM_PERSON_SIZE ||
                height < MINIMUM_HEIGHT;
    }

    public int getResultNumber(int number) {
        for (LadderLine line :
                ladderLines) {
            number = line.move(number);
        }
        return number;
    }

    public int sizeOfPerson() {
        return sizeOfPerson;
    }
}
