
package laddergame.view;

import laddergame.domain.Result;

import java.util.List;

public class ResultView {
    public static void showLadderLineResult(Result result) {
        System.out.println("\n사다리 결과\n");

        List<String> lineResult = result.getLineResult();
        for(String line : lineResult) {
            System.out.println(line);
        }
    }

    public static void showGameResult(Result result, String key) {
        System.out.println("\n실행 결과");

        List<String> gameResult =  result.getGameResult(key);
        for(String line : gameResult) {
            System.out.println(line);
        }
    }
}
