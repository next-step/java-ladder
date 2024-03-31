package nextstep.ladder.view;

import java.util.Scanner;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.user.Users;

public class Output {

    private static final Scanner scanner = new Scanner(System.in);

    private Output() {
    }

    public static void printResult(Users users, Lines lines) {
        System.out.println("실행결과");
        System.out.println(users);

        for (Line line : lines.getLines()) {
            System.out.print(String.format("%6s", "|"));
            for (Boolean point : line.getPoints()) {
                if (point) {
                    System.out.print(String.format("%5s", "-----|"));
                } else {
                    System.out.print(String.format("%5s", "     |"));
                }
            }
            System.out.println();
        }
    }
}
