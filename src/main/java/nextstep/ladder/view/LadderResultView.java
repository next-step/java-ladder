package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderLine;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-12 21:14
 */
public class LadderResultView {

    private static final int MINIMUM_MAXIMUM_VALUE = 5;
    private static final int FIRST_LINE_INDEX = 0;
    private static final String BLANK = " ";
    private static final String EMPTY = "    ";
    private static final String BRIDGE = "|-----";
    private static final String EMPTY_PIPE = "|     ";

    private static String leftPadBlank(String value) {
        return StringUtils.leftPad(value, MINIMUM_MAXIMUM_VALUE, BLANK);
    }

    private static void showList(List<String> names) {
        String result = names.stream()
                .map(LadderResultView::leftPadBlank)
                .collect(Collectors.joining(BLANK));

        System.out.println(result);
    }

    private static void showLadderLines(List<LadderLine> ladderLines) {
        ladderLines.forEach(line -> {
            showLine(line);
        });
    }

    private static void showLine(LadderLine line) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int lineNo = 0; lineNo < line.getPointOfLine().size(); lineNo++) {
            if (lineNo == FIRST_LINE_INDEX) {
                stringBuilder.append(EMPTY);
            }

            stringBuilder.append(getBridgeOrEmptyPipe(lineNo, line.getPointOfLine().get(lineNo)));
        }
        System.out.println(stringBuilder.toString());
    }

    private static String getBridgeOrEmptyPipe(int lineNo, Boolean point) {
        if (point) {
            return BRIDGE;
        }
        return EMPTY_PIPE;
    }

    public static void showLadderResult(List<String> result) {
        result.forEach(System.out::println);
    }

    public static void showLadder(LadderGame ladderGame) {
        showList(ladderGame.getParticipant());
        showLadderLines(ladderGame.getLadderLines());
        showList(ladderGame.getExecutionResult());
    }
}
