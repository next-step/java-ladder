package step3.view;

import step3.domain.Ladder;
import step3.domain.PlayerResult;
import step3.domain.Players;
import step3.domain.Results;

public class ResultView {
    private static final String RESULT_TEXT = "사다리 결과";
    private static final String INTERVAL = "%5s ";
    private static final String LINE = "-----";
    private static final String BAR = "|";
    private static final String BLANK = "     ";
    private static final String WHO_IS_WINNER_TEXT = "결과를 보고싶은 사람은?(종료하려면 'exit' 를 입력해 주세요.)";
    private static final String SHOW_RESULT_TEXT = "실행 결과";
    private static final String ALL = "all";
    private static final String EXIT = "exit";

    public static void showResult(PlayerResult playerResult) {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println(WHO_IS_WINNER_TEXT);
            String player = InputView.inputPlayer();
            System.out.println();

            isContinue = isExit(player);

            System.out.println(SHOW_RESULT_TEXT);
            showPlayerResult(player, playerResult);
            System.out.println();
        }
    }

    public static void showPlayerResult(String player, PlayerResult playerResult) {
        if (!player.equals(ALL)) {
            System.out.println(playerResult.getResultMapByKey(player));
        }
        if (player.equals(ALL)) {
            playerResult.getPlayerResultMap().forEach((k, v) -> System.out.println(k + " : " + v));
        }

    }

    public static boolean isExit(String flag) {
        if (flag.equals(EXIT)) {
            return false;
        }
        return true;
    }


    public static void showLadder(Ladder ladder, Players players, Results results) {
        System.out.println(RESULT_TEXT);
        players.getPlayers().forEach(p -> System.out.printf(INTERVAL, p.getName()));
        System.out.println();
        ladder.getLadder().forEach(line -> {
            line.getPoints().forEach(point -> {
                System.out.printf(isMovable(point.getLeft()) + BAR);
            });
            System.out.println();
        });
        results.getResults().forEach(r -> System.out.printf(INTERVAL, r.getResult()));
        System.out.println();
    }

    public static String isMovable(boolean movable) {
        if (movable) {
            return LINE;
        }
        return BLANK;
    }
}
