package step2.view;

import step2.domain.*;

import java.util.Map;
import java.util.stream.IntStream;

public class ResultView {
    public static final String LADDER_MOVE = "|-----";
    public static final String LADDER_STOP = "|     ";

    private ResultView() {
    }

    public static void printLadderStart() {
        System.out.print("\n     ");
    }

    public static void printLadder(Lines lines) {
        lines.getLines().forEach(line -> {
            ResultView.printLadderStart();
            ResultView.printLine(line);
            ResultView.printLadderEnd();
        });
    }

    private static void printLine(Line line) {
        IntStream.range(0, line.getSize())
                .mapToObj(line::isMoveable)
                .map(point -> point ? LADDER_MOVE : LADDER_STOP)
                .forEach(System.out::print);
    }

    public static void printLadderEnd() {
        System.out.print("|");
    }
  
    public static void printPlayer(Players players) {
        players.getPlayers()
                .stream()
                .map(Player::getNameWithBlank)
                .forEach(System.out::print);
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
                    return awardResult.getKey().getName() +" : "
                            + awardResult.getValue();
                }).forEach(System.out::println);
    }
}
