package reladder.domain;

import java.util.ArrayList;
import java.util.List;

public class DefaultLadderGenerator implements LadderGenerator {

    private static final int LOOP_INDEX = 0;

    private static DefaultLadderGenerator of() {
        return new DefaultLadderGenerator();
    }

    public static DefaultLadderGenerator getInstance() {
        return of();
    }

    @Override
    public Ladder generate(int sizeOfLine, int sizeOfPerson) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = LOOP_INDEX; i < sizeOfLine; i++) {
            LadderLine ladderLine = LadderLineGenerator.getInstance().generate(sizeOfPerson);
            ladderLines.add(ladderLine);
        }
        return new Ladder(ladderLines);
    }
}
