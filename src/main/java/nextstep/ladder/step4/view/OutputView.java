package nextstep.ladder.step4.view;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.step4.domain.ladder.DefaultLadder;
import nextstep.ladder.step4.domain.ladder.LadderResult;
import nextstep.ladder.step4.domain.player.Category;
import nextstep.ladder.step4.domain.player.Name;
import nextstep.ladder.step4.domain.player.Players;

public class OutputView {

    private static final int FIRST_PLAYERS = 0;
    private static final String BLANK = " ";
    private static final String LINE_FALSE = "     ";
    private static final String LINE_TRUE = "-----";
    private static final String STRING_FORMAT = "%6s";
    private static final String DELIMITER_JOIN = "";
    private static final String LINE_DELIMITER = "|";
    private static final String STOP_MESSAGE = "all";
    private static final String NAME_JOIN_CATEGORY = " : ";

    private OutputView() {
    }

    public static void ladderResult(Players players, Category category, DefaultLadder ladder) {
        System.out.println("\n사다리 결과\n");
        outputPlayers(players);
        outputLadder(players.get(FIRST_PLAYERS).length(), ladder);
        outputCategory(category);

    }

    public static void playerResult(Players players, Category category, LadderResult ladderResult) {
        String name = InputView.resultPlayerName();
        while (!STOP_MESSAGE.equals(name)) {
            int nameIndex = players.nameIndex(name);
            resultOnce(category, ladderResult, nameIndex);
            name = InputView.resultPlayerName();
        }

        resultAll(players, category, ladderResult);
    }

    private static void resultOnce(Category category, LadderResult ladderResult, int nameIndex) {
        System.out.println("실행결과");
        if (nameIndex < 0) {
            System.out.println("존재하지 않는 이름 입니다.");
            return;
        }

        System.out.println(category.get(ladderResult.get(nameIndex)) + "\n");
    }

    private static void resultAll(Players players, Category category, LadderResult ladderResult) {
        final int size = ladderResult.size();
        System.out.println("실행결과");
        for (int i = 0; i < size; i++) {
            System.out.println(players.get(i) + NAME_JOIN_CATEGORY + category.get(ladderResult.get(i)));
        }
    }

    private static void outputLadder(int firstLength, DefaultLadder ladder) {
        int size = ladder.size();
        for (int i = 0; i < size; i++) {
            List<Boolean> line = ladder.lines(i);

            String pi = blank(firstLength) + LINE_DELIMITER + line.stream()
                .map(point -> point ? LINE_TRUE : LINE_FALSE)
                .collect(Collectors.joining(LINE_DELIMITER));
            System.out.println(pi);
        }
    }

    private static void outputPlayers(Players players) {
        String joinPlayers = formatJoin(players.players());
        System.out.println(joinPlayers);
    }

    private static void outputCategory(Category category) {
        String joinCategory = formatJoin(category.category());
        System.out.println(joinCategory);
    }

    private static String formatJoin(List<Name> nameList) {
        return nameList.stream()
            .map(OutputView::format)
            .collect(Collectors.joining())
            .trim();
    }

    private static String format(Name name) {
        return String.format(STRING_FORMAT, name);
    }

    private static String blank(int length) {
        return String.join(DELIMITER_JOIN, Collections.nCopies(length, BLANK));
    }

}
