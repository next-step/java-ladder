package ladder.view;

import ladder.domain.Ladder;
import ladder.dto.Gamer;
import ladder.dto.Result;

import java.util.List;
import java.util.stream.IntStream;

public class LadderOutputView {
    public static void printGamers(List<Gamer> gamers, int maxNameLength) {
        System.out.println("\n사다리 결과");

        gamers.forEach(gamer -> {
            System.out.print(gamer.toString());
            IntStream.range(0, maxNameLength - gamer.getNameLength() + 1)
                    .forEach(name -> System.out.print(" "));
        });
        System.out.println();
    }

    public static void printLadder(Ladder ladder, int maxNameLength, int height) {
        int width = ladder.getLines().size();

        for (int i = 0; i < height; i++) {
            drawRow(ladder, maxNameLength, width, i);
            System.out.println();
        }

    }

    private static void drawRow(Ladder ladder, int maxNameLength, int width, int i) {
        System.out.print("|");
        for (int column = 0; column < width - 1; column++) {
            drawBlock(ladder, maxNameLength, i, column);
            System.out.print("|");
        }
    }

    private static void drawBlock(Ladder ladder, int maxNameLength, int height, int column) {
        if (ladder.getLines().get(column).getRows().get(height).isRow()) {
            IntStream.range(0, maxNameLength)
                    .forEach(count -> System.out.print("-"));
        } else {
            IntStream.range(0, maxNameLength)
                    .forEach(count -> System.out.print(" "));
        }
    }

    public static void printResults(List<Result> rewards, int maxNameLength) {
        rewards.forEach(reward -> {
            System.out.print(reward.toString());
            IntStream.range(0, maxNameLength - reward.getRewardLength() + 1)
                    .forEach(name -> System.out.print(" "));
        });
        System.out.println();
    }

    public static void printReward(String gamer) {
        System.out.println("\n실행 결과");
        System.out.println(gamer);
        System.out.println();
    }

    public static void printAllReward() {
        System.out.println("\n실행 결과");
        System.out.println("all");
        System.out.println();
    }
}
