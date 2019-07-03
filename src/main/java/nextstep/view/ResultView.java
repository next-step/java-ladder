package nextstep.view;

import nextstep.domain.*;

import java.util.stream.IntStream;

public class ResultView {
    private final static String LADDER_HORIZON_LINE = "-----";
    private final static String LADDER_VERTICAL_LINE = "|";
    private final static String LADDER_BLANK = "     ";
    private final static String USER_SEPARATOR = "   ";

    public static void printLadder(LadderGame ladderGame) {

        System.out.println("\n\n");
        System.out.println("실행결과");

        ladderGame.getUseGroup().stream()
                .map(User::getName)
                .forEach(name -> System.out.print(name + USER_SEPARATOR));

        System.out.println("\n");

        IntStream.range(0, ladderGame.getLadder().size())
                .forEach(i -> {
                            IntStream.range(0, ladderGame.getUseGroup().size()).forEach(j ->
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
    }
}
