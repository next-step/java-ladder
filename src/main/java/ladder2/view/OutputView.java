package ladder2.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder2.domain.Ladder;
import ladder2.domain.Link;
import ladder2.domain.LadderColumn;
import ladder2.domain.LadderRow;
import ladder2.domain.Player;
import ladder2.domain.Players;
import ladder2.domain.Prize;
import ladder2.domain.Prizes;

public class OutputView {

    private static final String LADDER_HEADER_MESSAGE = "실행결과\n";
    private static final String WHOLE_GAME_RESULT_HEADER_MESSAGE = "실행 결과";
    private static final String WHOLE_GAME_RESULT_FORMAT = "%s : %s\n";
    private static final String FIRST_COLUMN = "    |";
    private static final String HORIZONTAL_LINE = "-----|";
    private static final String NO_HORIZONTAL_LINE = "     |";
    private static final String NAME_FORMAT = "%5s";
    private static final String RESULT_FORMAT = "%5s";
    private static final String NAME_DELIMITER = " ";
    private static final String RESULT_DELIMITER = " ";

    public void printLadder(Ladder ladder, Players players, Prizes prizes) {
        System.out.println(LADDER_HEADER_MESSAGE);

        printPlayerNames(players);
        ladder.rows().forEach(this::printRow);
        printPrizeNames(prizes);
    }

    private void printPlayerNames(Players players) {
        String strNames = players.names().stream()
            .map(name -> String.format(NAME_FORMAT, name))
            .collect(Collectors.joining(NAME_DELIMITER));
        System.out.println(strNames);
    }

    private static void printPrizeNames(Prizes prizes) {
        String strResults = prizes.names().stream()
            .map(result -> String.format(RESULT_FORMAT, result))
            .collect(Collectors.joining(RESULT_DELIMITER));
        System.out.println(strResults);
    }

    private void printRow(LadderRow row) {
        List<LadderColumn> columns = row.columns();
        System.out.print(FIRST_COLUMN);
        int secondFromBackIndex = columns.size() - 2;
        for (int i = 0; i <= secondFromBackIndex; i++) {
            printColumn(columns.get(i));
        }
        System.out.println();
    }

    private void printColumn(LadderColumn column) {
        if (column.link() == Link.RIGHT_LINK) {
            System.out.print(HORIZONTAL_LINE);
            return;
        }
        System.out.print(NO_HORIZONTAL_LINE);
    }

    public void printPrize(Players players) {
        System.out.println(WHOLE_GAME_RESULT_HEADER_MESSAGE);
        for (Player player : players.value()) {
            Prize prize = player.prize();
            System.out.printf(WHOLE_GAME_RESULT_FORMAT, player.name(), prize.name());
        }
    }

    public void printPrize(Player player) {
        Prize prize = player.prize();
        System.out.println(prize.name());
    }
}
