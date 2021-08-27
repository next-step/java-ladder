package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.domain.Users;
import ladder.domain.WinningItems;

import java.util.Map;

public class OutputView {
    private static final String LADDER_TITLE = "\n사다리 결과\n";
    private static final String RESULT_TITLE = "\n실행 결과";

    public static void printLadderGameInfo(Users users, Ladder ladder, WinningItems winningItems) {
        OutputView.printNames(users);
        OutputView.printLadder(ladder);
        OutputView.printItems(winningItems);
    }

    private static void printNames(Users users) {
        System.out.println(LADDER_TITLE);
        users.getNames().forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        System.out.println(ladder.getLadderString());
    }

    private static void printItems(WinningItems winningItems) {
        winningItems.getWinningItems()
                    .forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    public static void printResult(String name, Map<Name, String> result) {
        System.out.println(RESULT_TITLE);
        if ("all".equals(name)) {
            result.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
            return;
        }
        System.out.println(result.get(Name.valueOf(name)));
    }
}
