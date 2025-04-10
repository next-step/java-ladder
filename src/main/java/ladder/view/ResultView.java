package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;

import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_MESSAGE = "\n실행결과\n";

    public void printResult(Players players, Ladder ladder) {
        System.out.println(RESULT_MESSAGE);
        printPlayersName(players);
        printLadder(ladder);
    }

    private void printPlayersName(Players players) {
        String playerString = players.getNames().stream()
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining(" "));
        System.out.println(playerString);
    }

    private void printLadder(Ladder ladder) {
        String ladderString = ladder.getLines().stream()
                .map(line -> line.getPoints().stream()
                        .map(point -> point.hasPoint() ? "-----" : "     ")
                        .collect(Collectors.joining("|", "    |", "|"))
                )
                .collect(Collectors.joining("\n"));
        System.out.println(ladderString);
    }

}
