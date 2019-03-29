package console;

import common.SpacingLetterMaker;
import domain.Line;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ConsoleOutput {

    public static void printResult(List<String> users, List<Line> lines) {
        System.out.println("실행결과");
        System.out.println();

        int spacingLetterLength = SpacingLetterMaker.makeLengthFrom(users);

        users.forEach(user -> System.out.print(StringUtils.center(user, spacingLetterLength)));
        System.out.println();

        lines.forEach(line -> System.out.println(line.paint(spacingLetterLength)));
        System.out.println();
    }
}
