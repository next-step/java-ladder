package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderBridge;
import nextstep.ladder.domain.LadderRequireElement;
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
    private static final String BLANK = " ";

    private static void printLadderLine(List<LadderBridge> line) {
        line.forEach(ladderLine -> System.out.print(ladderLine.getBridge()));
    }

    private static String leftPadBlank(String value) {
        return StringUtils.leftPad(value, MINIMUM_MAXIMUM_VALUE, BLANK);
    }

    private static void showLadder(List<List<LadderBridge>> showLadder) {
        showLadder.forEach(line -> {
            printLadderLine(line);
            System.out.println();
        });
    }

    private static void showList(List<String> names) {
        String result = names.stream()
                .map(LadderResultView::leftPadBlank)
                .collect(Collectors.joining(BLANK));

        System.out.println(result);
    }

    public static void showLadder(LadderRequireElement ladderRequireElement, Ladder ladder) {
        showList(ladderRequireElement.getParticipant());
        showLadder(ladder.showLadder());
        showList(ladderRequireElement.getExecutionResult());
    }

    public static void showLadderResult(List<String> result) {
        result.forEach(System.out::println);
    }

}
