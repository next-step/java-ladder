package nextstep.ladder.view;

import nextstep.ladder.domain.LadderBridge;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-12 21:14
 */
public class LadderResultView {

    public static void showLadder(List<List<LadderBridge>> showLadder) {
        showLadder.stream().forEach(line -> {
            printLadderLine(line);
            System.out.println();
        });
    }

    private static void printLadderLine(List<LadderBridge> line) {
        line.stream().forEach(ladderLine -> {
            System.out.print(ladderLine.getBridge());
        });
    }

    public static void showUsers(List<String> names) {
        String result = names.stream().collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
