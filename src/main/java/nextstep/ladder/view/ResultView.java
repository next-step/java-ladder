package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import nextstep.ladder.domain.LadderJackpot;
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

    private ResultView() {

    }

    public static ResultView getInstance() {
        if(Objects.isNull(resultView)) {
            resultView = new ResultView();
        }

        return resultView;
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

    public LadderJackpot printLadderLines(int nameSize, int maxLadderHeight) {
        Boolean[][] ladders = new Boolean[maxLadderHeight][nameSize];
        for(int i = 0; i < maxLadderHeight; i++) {
            Lines lines = Lines.of(nameSize, new RandomCreationStrategy());
            printLines(lines);
            ladders[i] = lines.toArray();
        }
        return LadderJackpot.of(ladders);
    }

    private void printLines(Lines lines) {
        System.out.println(makeLine(lines.getLines())
                               .toString()
                               .replaceAll(REPLACE_STRING, TRANSFER_STRING)
                               .replaceAll(SPLIT_STRING + SPACE, TRANSFER_STRING));
    }

    public void printLadderNames(LadderNames ladderNames) {
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

    public void printJackpot(LadderNames ladderNames) {
        Object[] names = Arrays.stream(ladderNames.toString().split(SPLIT_STRING)).toArray();


        System.out.println();
    }
}
