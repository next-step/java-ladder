package reladder.domain;

import java.util.ArrayList;
import java.util.List;

public class DefaultLadderGenerator implements LadderGenerator {

    private static final int LOOP_INDEX = 0;

    private static DefaultLadderGenerator defaultLadderGenerator;

    public static DefaultLadderGenerator getInstance() {
        if (defaultLadderGenerator == null) {
            defaultLadderGenerator = new DefaultLadderGenerator();
        }
        return defaultLadderGenerator;
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
