package console;

import domain.LadderGame;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ConsoleOutput {

    public static void printLadder(List<String> users, LadderGame ladderGame) {
        System.out.println("실행결과");
        System.out.println();

        int spacingLetterLength = SpacingLetterHelper.makeLengthFrom(users);

        users.forEach(user -> System.out.print(StringUtils.center(user, spacingLetterLength)));
        System.out.println();

        ladderGame.paint(ladder -> System.out.println(ladder.paint(spacingLetterLength)));
        System.out.println();
    }
}
