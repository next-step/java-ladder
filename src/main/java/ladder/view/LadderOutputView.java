package ladder.view;

import ladder.domain.Gamer;
import ladder.domain.Ladder;

import java.util.List;
import java.util.stream.IntStream;

public class LadderOutputView {
    public static void printResult(List<Gamer> gamers, int maxNameLength, Ladder ladder) {
        System.out.println("\n실행결과");

        printGamers(gamers, maxNameLength);
        printLadder(ladder, maxNameLength);
    }

    public static void printGamers(List<Gamer> gamers, int maxNameLength) {
        gamers.forEach(gamer -> {
            System.out.print(gamer.toString());

            IntStream.range(0, maxNameLength - gamer.getNameLength() + 1)
                    .forEach(name -> System.out.print(" "));
        });
        System.out.println();
    }

    private static void printLadder(Ladder ladder, int maxNameLength) {

        int width = ladder.getLines().size();
        int height = ladder.getHeight();

        for (int k = 0; k < height; k++) {
            System.out.print("|");
            for (int i = 0; i < width - 1; i++) {
                if (ladder.getLines().get(i).getLine().get(k)) {
                    for (int j = 0; j < maxNameLength; j++) {
                        System.out.print("-");
                    }
                } else {
                    for (int j = 0; j < maxNameLength; j++) {
                        System.out.print(" ");
                    }
                }
                System.out.print("|");
            }
            System.out.println();
        }

    }
}
