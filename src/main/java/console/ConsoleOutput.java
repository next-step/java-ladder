package console;

import domain.LadderGame;
import domain.LadderGameResult;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ConsoleOutput {

    public static void printLadder(List<String> users, LadderGame ladderGame, List<String> results) {
        System.out.println("실행결과");
        System.out.println();

        int spacingLetterLength = SpacingLetterHelper.makeLengthFrom(users);

        users.forEach(user -> System.out.print(StringUtils.rightPad(user, spacingLetterLength)));
        System.out.println();

        ladderGame.paint(ladder -> System.out.println(ladder.paint(spacingLetterLength)));
        System.out.println();

        results.forEach(result -> System.out.print(StringUtils.rightPad(result, spacingLetterLength)));
        System.out.println();
    }

    public static void printResult(LadderGameResult gameResult, int userIndex, List<String> results) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println(results.get(gameResult.finalPositionOf(userIndex)));
    }

    public static void printResult(LadderGameResult gameResult, List<String> users, List<String> results) {
        System.out.println();
        System.out.println("실행결과");

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i) + " : " + results.get(gameResult.finalPositionOf(i)));
        }
    }
}
