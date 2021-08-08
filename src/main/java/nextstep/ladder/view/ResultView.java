package nextstep.ladder.view;

import nextstep.ladder.domain.LadderLineCreationStrategy;
import nextstep.ladder.domain.LadderNames;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.exception.InitLineCreationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final int LETTER_LIMIT = 5;
    private static final String SPACE = " ";
    private static final String REPLACE_STRING =  "\\[|\\]";
    private static final String INIT_LINE = "    |";
    private static final String NONE_LINE = "     |";
    private static final String IS_LINE = "-----|";

    public void print(LadderNames ladderNames, int maxLadderHeight) {
        printLadderName(ladderNames);
        printLadderLines(ladderNames, maxLadderHeight);
    }

    private static List<String> makeLine(List<Line> lines) {
        return lines.stream()
                .map(ResultView::drawLine)
                .collect(Collectors.toList());
    }

    private static boolean isInitLine(Line line) {
        if(line == Line.INITLINE) {
            return true;
        }
        throw new InitLineCreationException();
    }

    private static String drawLine(Line line) {
        if (isInitLine(line)) {
            return INIT_LINE;
        }

        if(line.isExist()) {
            return IS_LINE;
        }

        return NONE_LINE;
    }

    public void printLadderLines(LadderNames ladderNames, int maxLadderHeight) {
        for(int i = 0; i < maxLadderHeight; i++) {
            printLines(Lines.of(initLine(), ladderNames.size(), new LadderLineCreationStrategy()));
        }
    }

    private void printLines(Lines lines) {
        System.out.println(makeLine(lines.getLines())
                               .toString()
                               .replaceAll(REPLACE_STRING, "")
                               .replaceAll(", ", ""));
    }

    public void printLadderName(LadderNames ladderNames) {
        Object[] names = Arrays.stream(ladderNames.toString().split(","))
                               .map(this::fitLength)
                               .toArray();

        System.out.println(Arrays.toString(names).replaceAll(REPLACE_STRING, "").replaceAll(",", ""));
    }

    private String fitLength(String name) {
        if(name.length() < LETTER_LIMIT) {
            name = fitLength(SPACE.concat(name));
        }

        return name;
    }

    private List<Line> initLine() {
        List<Line> lines = new ArrayList<>();
        lines.add(Line.INITLINE);
        return lines;
    }
}
