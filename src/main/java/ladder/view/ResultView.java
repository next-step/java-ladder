package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.Line;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String FIRST_FORMAT = "    |";
    private static final String BLANK_FORMAT = "     ";
    private static final String LINE_FORMAT = "-----";
    private static final String POLE_FORMAT = "|";
    private static final String NAME_FORMAT = "%5s ";

    public static void outputOfResult(LadderGame ladderGame) {
        changeNextLine();
        System.out.println("실행 결과");
        printPlayers(ladderGame.isPlayersNameList());
        changeNextLine();
        printLadder(ladderGame.isLadder());
    }

    private static void printPlayers(List<String> playerNameList) {
        playerNameList.stream()
                .forEach(playerName -> System.out.print(String.format(NAME_FORMAT, playerName)));
    }

    private static void printLadder(List<Line> ladder) {
        for (Line line : ladder) {
            String ladderLine = line.isLineStream()
                    .map(x -> x ? LINE_FORMAT : BLANK_FORMAT)
                    .collect(Collectors.joining(POLE_FORMAT));
            System.out.println(FIRST_FORMAT + ladderLine + POLE_FORMAT);
        }
    }

    private static void changeNextLine() {
        System.out.println();
    }
}
