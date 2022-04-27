package nextstep.ladder;

import java.util.List;

public class ResultView {

    private static final String EXISTED_LINE = "|-----";
    private static final String NOT_EXISTED_LINE = "|     ";

    public void printPlayersName(Players players) {
        System.out.println("실행 결과");
        players.getPlayers()
                .forEach(playerName -> {
                    System.out.print(playerName + "    ");
                });
        System.out.println();
    }

    public void printLadders(Ladders ladders) {
        ladders.getLines()
                .stream()
                .map(Line::getPoints)
                .forEach(ResultView::printLines);
    }

    private static void printLines(List<Boolean> booleans) {
        booleans.forEach(line -> {
            if (line) {
                System.out.print(EXISTED_LINE);
                return;
            }
            System.out.print(NOT_EXISTED_LINE);
        });
        System.out.println();
    }
}
