package step4.view;


import step2.exception.IllegalPlayerName;
import step4.domain.*;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ResultView {
    public static final int FULL_LENGTH = 6;
    public static final String LADDER_MOVE = "|-----";
    public static final String LADDER_STOP = "|     ";

    private ResultView() {
    }

    public static void printLadderStart() {
        System.out.print("\n     ");
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines().forEach(line -> {
            ResultView.printLadderStart();
            ResultView.printLine(line, ladder.getLines().size());
        });
    }

    //
    private static void printLine(LadderLine line, int countOfPerson) {
        IntStream.range(0, countOfPerson - 1)
                .mapToObj(line::isMoveable)
                .map(point -> point.isMoveable() ? LADDER_MOVE : LADDER_STOP)
                .forEach(System.out::print);
    }

    public static void printPlayer(Players players) {
        players.getPlayers()
                .stream()
                .map(player -> getNameWithBalnk(player.getName()))
                .forEach(System.out::print);
    }

    public static String getNameWithBalnk(String playerName) {
        int blankSize = FULL_LENGTH - playerName.length();
        String blank = Stream.generate(() -> " ")
                .limit(blankSize)
                .collect(Collectors.joining());

        return blank + playerName;
    }

    public static void printPrizes(Prizes prizes) {
        System.out.println();
        prizes.getPrizes()
                .stream()
                .map(prize -> prize + "    ")
                .forEach(System.out::print);
    }

    public static void printLadderAward(Map<Player, String> award) {
        System.out.println("\n실행 결과");
        award.entrySet()
                .stream()
                .map(awardResult -> {
                    if (award.size() == 1) {
                        return awardResult.getValue();
                    }
                    return awardResult.getKey().getName() + " : "
                            + awardResult.getValue();
                }).forEach(System.out::println);
    }
}
