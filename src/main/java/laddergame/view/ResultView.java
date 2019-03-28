
package laddergame.view;

import laddergame.domain.LadderGameResult;
import laddergame.domain.LadderLineResult;

import java.util.List;

public class ResultView {
    public static void showLadderLineResult(LadderLineResult result) {
        System.out.println("\n사다리 결과\n");
        List<String> ladderLineResult = result.getLadderLineResult();
        for(String line : ladderLineResult) {
            System.out.println(line);
        }
    }

    public static void showGameResult(LadderGameResult result, String key) {
        System.out.println("\n실행 결과");

        List<String> resultStrings =  result.getRewardResultStrings(key);
        for(String line : resultStrings) {
            System.out.println(line);
        }
    }
}
