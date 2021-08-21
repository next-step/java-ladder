package nextstep.view;


import nextstep.ladder.Ladder;
import nextstep.ladder.LadderGame;

import java.util.stream.IntStream;

import static nextstep.ladder.CommonConstans.*;

public class ResultView {

    private static StringBuffer stringLine = new StringBuffer();
    private static int playerCount;


    public static void printLadderResult(LadderGame executeLadderGames) {

        playerCount = executeLadderGames.getPlayers().size();

        executeLadderGames.getPlayers()
                .stream()
                .map(player -> player.getPlayer() + ONE_BLANK_SPACE)
                .forEach(System.out::print);

        System.out.println();


        IntStream.range(NUMBER_ZERO, executeLadderGames.getladders().size())
                .forEach(i -> drawLadderLine(playerCount, executeLadderGames.getladders().get(i)));

        System.out.println(stringLine);
    }


    private static void drawLadderLine(int playerCount, Ladder ladder) {

        IntStream.range(NUMBER_ZERO, playerCount)
                .forEach(index -> createStringLine(ladder.getLines().get(index), index));
        stringLine.append("\n");
    }

    private static void createStringLine(boolean line, int index) {
        if (index == (playerCount - NUMBER_ONE)) {
            stringLine.append(FALSE_LINE);
            return;
        }

        if (line) {
            stringLine.append(TRUE_LINE);
            return;
        }
        stringLine.append(FALSE_LINE);
    }

}
