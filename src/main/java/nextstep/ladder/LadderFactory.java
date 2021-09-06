package nextstep.ladder;

import nextstep.ladder.line.HorizontalLine;
import nextstep.ladder.line.HorizontalLineFactory;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {

    public static Ladder generate(int height, int numberOfParticipants) {
        List<HorizontalLine> horizontalLines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            HorizontalLine horizontalLine = HorizontalLineFactory.generate(numberOfParticipants);
            System.out.println(horizontalLine);
            horizontalLines.add(horizontalLine);
        }

        return new Ladder(numberOfParticipants, horizontalLines);
    }
}
