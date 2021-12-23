package rick.view;

import rick.domain.Ladder;
import rick.domain.Line;
import rick.domain.Player;
import rick.domain.Players;

public class ResultView {

    private ResultView() {
    }

    public static void drawResult(Players players, Ladder ladder, int ladderLineCount) {
        System.out.println("실행결과");
        System.out.println();

        players.getPlayers()
            .stream()
            .map(Player::getName)
            .forEach(name -> System.out.printf("%6s", name));

        System.out.println();

        for (Line line : ladder.getLines()) {
            System.out.print("     |");
            for (Boolean point : line.getPoints()) {
                if (point) {
                    System.out.print("-----");

                } else {
                    System.out.print("     ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
