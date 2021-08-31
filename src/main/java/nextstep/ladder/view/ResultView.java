package nextstep.ladder.view;


import java.util.stream.Collectors;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderColumn;
import nextstep.ladder.domain.LadderRow;
import nextstep.ladder.domain.Players;

public class ResultView {

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
        System.out.println();
        ladder.getLadderRows().stream()
            .forEach(row -> printLadderRow(row));
    }

    private void printLadderRow(LadderRow row) {
        String rowString = createLadderRowString(row);
        System.out.println(rowString);
    }

    private String createLadderRowString(LadderRow row) {

        return row.getLadderColumns().stream()
            .map(c -> getColumnString(c))
            .collect(Collectors.joining());
    }

    private String getColumnString(LadderColumn column) {
        return column.value() ? "|-----" : "|     ";
    }

    private void printPlayerNames(Players players) {
        players.stream().forEach(p -> System.out.print(p.getName()));
    }

    private static class ResultViewHolder {

        private static final ResultView instance = new ResultView();
    }


}
