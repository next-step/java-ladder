package nextstep.ladder.view;


import java.util.stream.Collectors;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderColumn;
import nextstep.ladder.domain.LadderRow;
import nextstep.ladder.domain.Players;

public class ResultView {

    public static final String COLUMN_WITH_LINE = "|-----";
    public static final String COLUMN = "|     ";
    public static final int NAMES_PADDING_SIZE = 6;

    private ResultView() {
    }

    public static ResultView getInstance() {
        return ResultViewHolder.instance;
    }


    public void showLadderGame(Players players, Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();

        printPlayerNames(players);
        printLadder(ladder);
    }

    private void printLadder(Ladder ladder) {
        ladder.getLadderRows()
            .forEach(this::printLadderRow);
    }

    private void printLadderRow(LadderRow row) {
        String rowString = createLadderRowString(row);
        System.out.println(rowString);
    }

    private String createLadderRowString(LadderRow row) {

        return row.getLadderColumns().stream()
            .map(this::getColumnString)
            .collect(Collectors.joining());
    }

    private String getColumnString(LadderColumn column) {
        return column.hasVerticalLine() ? COLUMN_WITH_LINE : COLUMN;
    }

    private void printPlayerNames(Players players) {
        String playerNamesWithPadding = players.stream()
            .map(p -> addRightPadding(p.getName(), NAMES_PADDING_SIZE))
            .collect(Collectors.joining());

        System.out.println(playerNamesWithPadding);
    }

    private String addRightPadding(String str, int size) {
        return String.format("%-" + size + "s", str);
    }

    private static class ResultViewHolder {

        private static final ResultView instance = new ResultView();
    }


}
