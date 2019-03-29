package console;

import domain.Line;
import java.util.List;

public class ConsoleOutput {

    public static void printResult(List<String> users, List<Line> lines) {
        System.out.println("실행결과");
        System.out.println();

        users.forEach(user -> System.out.print(user + "   "));
        System.out.println();

        lines.forEach(line -> System.out.println(line.paint()));
        System.out.println();
    }
}
