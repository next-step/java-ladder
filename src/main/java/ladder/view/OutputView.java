package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.row.Row;
import ladder.domain.row.Rows;
import ladder.domain.step.Step;

import static ladder.domain.player.Name.MAX_LENGTH;

public class OutputView {
    private static final String CROSSABLE_STEP = "-----";
    private static final String UN_CROSSABLE_STEP = "     ";
    private static final String BEAM = "|";

    private OutputView() {
    }

    public static void printLadder(Ladder ladder) {
        printPlayers(ladder.getPlayers());
        printRows(ladder.getRows());
    }

    private static void printPlayers(Players players) {
        players.getPlayers()
                .forEach(OutputView::printPlayer);
        System.out.println();
    }

    private static void printPlayer(Player player) {
        int dif = MAX_LENGTH - player.getName().length();

        System.out.print(player.getName() + " ".repeat(dif + 1));
    }

    private static void printRows(Rows rows) {
        rows.getRows()
                .forEach(OutputView::printRow);
    }

    private static void printRow(Row row) {
        System.out.println(row.getSteps()
                .stream()
                .map(OutputView::getStepString)
                .reduce(BEAM, (str, cur) -> str + cur + BEAM));
    }

    private static String getStepString(Step step) {
        if (step.isCrossable()) {
            return CROSSABLE_STEP;
        }
        return UN_CROSSABLE_STEP;
    }
}
