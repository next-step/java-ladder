package ladder.view;

import ladder.domain.*;

import java.util.Comparator;
import java.util.stream.IntStream;

public class ResultView {
    private final static String LADDER_HORIZON_LINE = "-----";
    private final static String LADDER_VERTICAL_LINE = "|";
    private final static String LADDER_BLANK = "     ";
    private final static String USER_SEPARATOR = "   ";

    public static void printLadder(LadderFactory ladderFactory, UserGroup userGroup, GameResult result) {
        System.out.println("\n사다리 결과\n");

        userGroup.getUserGroup().stream()
                .map(SingleUser::getName)
                .forEach(name -> System.out.print(name + USER_SEPARATOR));
        System.out.println("\n");

        IntStream.range(0, ladderFactory.getLadder().size())
                .forEach(i -> {
                            IntStream.range(0, userGroup.getUserGroup().size())
                                    .forEach(j ->
                                            {
                                                if (ladderFactory.getLadder().get(i).getPoints().get(j).getPoint() == Boolean.TRUE) {
                                                    System.out.print(LADDER_HORIZON_LINE + LADDER_VERTICAL_LINE);
                                                } else {
                                                    System.out.print(LADDER_BLANK + LADDER_VERTICAL_LINE);
                                                }
                                            }
                                    );
                            System.out.println("\n");
                        }
                );

        result.getgameReward().stream()
                .map(GameReward::getNameReward)
                .forEach(name -> System.out.print(name + USER_SEPARATOR));
        System.out.println("\n");
    }

    public static void showResult(String request, GameResult result) {
        System.out.println("\n실행 결과");

        if (request.equals("all")) {
            result.getgameReward().stream()
                    .sorted(Comparator.comparing(GameReward::getNameOfWinner))
                    .forEach(i -> System.out.println(i.getNameOfWinner() + ": " + i.getNameReward()));
        } else {
            result.getgameReward().stream()
                    .filter(i -> i.getNameOfWinner().equals(request))
                    .forEach(i -> System.out.println(i.getNameReward()));
        }
    }
}
