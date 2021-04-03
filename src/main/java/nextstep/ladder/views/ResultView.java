package nextstep.ladder.views;

import nextstep.ladder.domain.GameResult;

public class ResultView {
    public static void showLadder(GameResult result) {
        String stringBuilder = "실행 결과" +
                "\n" +
                result.playersNames() +
                "\n" +
                result.ladder();
        System.out.println(stringBuilder);
    }
}
