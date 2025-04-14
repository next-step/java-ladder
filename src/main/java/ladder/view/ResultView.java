package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Results;

import java.util.stream.Collectors;

public class ResultView {
    private static final String LADDER_MESSAGE = "\n사다리 결과";
    private static final String RESULT_MESSAGE = "\n실행결과";

    public void printResult(Players players, Ladder ladder, Results results) {
        System.out.println(LADDER_MESSAGE);
        printPlayersName(players);
        printLadder(ladder);
        printResultsName(results);
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

    private void printResultsName(Results results) {
        String resultString = results.getNames().stream()
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining(" "));
        System.out.println(resultString);
    }

    public void printGameResult(String result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(result);
    }

}
