package nextstep.ladder.view;

import nextstep.ladder.domain.LadderLineCreationStrategy;
import nextstep.ladder.domain.LadderNames;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;

import java.util.Arrays;

public class ResultView {
    private static final int LETTER_LIMIT = 5;
    private static final String SPACE = " ";
    private static final String REPLACE_STRING =  "\\[|\\]";

    public void print(LadderNames ladderNames, int maxLadderHeight) {
        printLadderName(ladderNames);
        printLadderLines(ladderNames, maxLadderHeight);
    }

    public void printLadderLines(LadderNames ladderNames, int maxLadderHeight) {
        for(int i = 0; i < maxLadderHeight; i++) {
            printLines(Lines.of(Line.initLine(), ladderNames.size(), new LadderLineCreationStrategy()));
        }
    }

    private void printLines(Lines lines) {
        System.out.println(Line.makeLine(lines.getLines())
                               .toString()
                               .replaceAll(REPLACE_STRING, "")
                               .replaceAll(", ", ""));
    }

    public void printLadderName(LadderNames ladderNames) {
        Object[] names = Arrays.stream(ladderNames.toString().split(","))
                               .map(this::fitLength).toArray();

        System.out.println(Arrays.toString(names).replaceAll(REPLACE_STRING, "").replaceAll(",", ""));
    }

    private String fitLength(String name) {
        if(name.length() < LETTER_LIMIT) {
            name = fitLength(SPACE.concat(name));
        }

        return name;
    }
}
