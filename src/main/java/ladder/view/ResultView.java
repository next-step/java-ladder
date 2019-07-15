package ladder.view;

import ladder.domain.*;

import java.util.Comparator;
import java.util.List;

public class ResultView {
    private final static String LADDER_HORIZON_LINE = "-----";
    private final static String LADDER_VERTICAL_LINE = "|";
    private final static String LADDER_BLANK = "     ";
    private final static String USER_SEPARATOR = "   ";

    public static void printLadder(List<LadderLine> ladder, UserGroup userGroup, GameResult result) {
        System.out.println("\n사다리 결과\n");
        // User 출력
        userGroup.getUserGroup().stream()
                .map(SingleUser::getName)
                .forEach(name -> System.out.print(name + USER_SEPARATOR));

        System.out.println("\n");
        // 사다리 출력
        for (int i = 0; i < ladder.size(); i++) {
            for (int j = 0; j < userGroup.getUserGroup().size(); j++) {
                if (ladder.get(i).getPoints().get(j).getDirection().isRight()) {
                    System.out.print(LADDER_VERTICAL_LINE + LADDER_HORIZON_LINE);
                } else {
                    System.out.print(LADDER_VERTICAL_LINE + LADDER_BLANK);
                }
            }
            System.out.println("\n");
        }
        // 실행 결과 출력
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
