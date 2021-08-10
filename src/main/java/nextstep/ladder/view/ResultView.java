package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import nextstep.ladder.domain.RandomCreationStrategy;
import nextstep.ladder.domain.LadderNames;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;

public class ResultView {
    private static final int LETTER_LIMIT = 5;
    private static final String SPACE = " ";
    private static final String REPLACE_STRING =  "\\[|\\]";
    private static final String INIT_LINE = "    |";
    private static final String NONE_LINE = "     |";
    private static final String IS_LINE = "-----|";
    private static final String SPLIT_STRING = ",";
    private static final String TRANSFER_STRING = "";

    private static ResultView resultView = null;

    private ResultView(LadderNames ladderNames, int maxLadderHeight) {
        print(ladderNames, maxLadderHeight);
    }

    public static ResultView getInstance(LadderNames ladderNames, int maxLadderHeight) {
        if(Objects.isNull(resultView)) {
            resultView = new ResultView(ladderNames, maxLadderHeight);
        }

        return resultView;
    }

    public void print(LadderNames ladderNames, int maxLadderHeight) {
        printLadderName(ladderNames);
        printLadderLines(ladderNames.size(), maxLadderHeight);
    }

    private static List<String> makeLine(List<Line> lines) {
        return lines.stream()
                .map(ResultView::drawLine)
                .collect(Collectors.toList());
    }

    private static String drawLine(Line line) {
        if (line == Line.INIT_LINE) {
            return INIT_LINE;
        }

        if(line.isExist()) {
            return IS_LINE;
        }

        return NONE_LINE;
    }

    private void printLadderLines(int nameSize, int maxLadderHeight) {
        for(int i = 0; i < maxLadderHeight; i++) {
            printLines(Lines.of(nameSize, new RandomCreationStrategy()));
        }
    }

    private void printLines(Lines lines) {
        System.out.println(makeLine(lines.getLines())
                               .toString()
                               .replaceAll(REPLACE_STRING, TRANSFER_STRING)
                               .replaceAll(SPLIT_STRING + SPACE, TRANSFER_STRING));
    }

    private void printLadderName(LadderNames ladderNames) {
        Object[] names = Arrays.stream(ladderNames.toString().split(SPLIT_STRING))
                               .map(this::fitLength)
                               .toArray();

        System.out.println(Arrays.toString(names).replaceAll(REPLACE_STRING, TRANSFER_STRING).replaceAll(SPLIT_STRING, TRANSFER_STRING));
    }

    private String fitLength(String name) {
        if(name.length() < LETTER_LIMIT) {
            name = fitLength(SPACE.concat(name));
        }

        return name;
    }
}
