package ladder.view;

import ladder.domain.GameReward;
import ladder.domain.GameUser;
import ladder.domain.LadderGame;

import java.util.Comparator;
import java.util.stream.IntStream;

public class ResultView {
    private final static String LADDER_HORIZON_LINE = "-----";
    private final static String LADDER_VERTICAL_LINE = "|";
    private final static String LADDER_BLANK = "     ";
    private final static String USER_SEPARATOR = "   ";

    public static void printLadder(LadderGame ladderGame) {
        System.out.println("\n사다리 결과\n");

        ladderGame.getUseGroup().stream()
                .map(GameUser::getName)
                .forEach(name -> System.out.print(name + USER_SEPARATOR));
        System.out.println("\n");
        IntStream.range(0, ladderGame.getLadder().size())
                .forEach(i -> {
                            IntStream.range(0, ladderGame.getUseGroup().size())
                                    .forEach(j ->
                                            {
                                                if (ladderGame.getLadder().get(i).getPoints().get(j) == Boolean.TRUE) {
                                                    System.out.print(LADDER_HORIZON_LINE + LADDER_VERTICAL_LINE);
                                                } else {
                                                    System.out.print(LADDER_BLANK + LADDER_VERTICAL_LINE);
                                                }
                                            }
                                    );
                            System.out.println("\n");
                        }
                );

        ladderGame.getgameReward().stream()
                .map(GameReward::getNameReward)
                .forEach(name -> System.out.print(name + USER_SEPARATOR));
        System.out.println("\n");
    }

    public static void showResult(String request, LadderGame ladderGame) {
        System.out.println("\n실행 결과");

        if (request.equals("all")) {
            ladderGame.getgameReward().stream()
                    .sorted(Comparator.comparing(GameReward::getNameOfWinner))
                    .forEach(i -> System.out.println(i.getNameOfWinner() + ": " + i.getNameReward()));
        } else {
            ladderGame.getgameReward().stream()
                    .filter(i -> i.getNameOfWinner().equals(request))
                    .forEach(i -> System.out.println(i.getNameReward()));
        }
    }

}
