
package laddergame.view;

import laddergame.domain.Result;

import java.util.List;

public class ResultView {
    public static void showLadderLines(Result result) {
        System.out.println("\n사다리 결과\n");
        List<String> ladderLineStrings = result.getLadderLineStrings();
        for(String line : ladderLineStrings) {
            System.out.println(line);
        }
    }

    public static void showRewardResult(Result result, String key) {
        System.out.println("\n실행 결과");

        List<String> resultStrings =  result.getRewardResultStrings(key);
        for(String line : resultStrings) {
            System.out.println(line);
        }
    }
}
