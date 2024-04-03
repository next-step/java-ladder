package nextstep.ladder.view;

import nextstep.ladder.domain.line.LadderConstructionStatus;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.user.Users;

public class Output {

    private Output() {
    }

    public static void printResult(Users users, Lines lines) {
        System.out.println("실행결과");
        users.getUsers()
            .forEach(user -> System.out.print(String.format("%6s", user.getUserName())));
        System.out.println();
        for (Line line : lines.getLines()) {
            System.out.print(String.format("%6s", "|"));
            for (LadderConstructionStatus status : line.getPoints()) {
                if (!status.isLadderConstructionStatusFalse()) {
                    System.out.print(String.format("%6s", "-----|"));
                } else {
                    System.out.print(String.format("%6s", "     |"));
                }
            }
            System.out.println();
        }
    }
}
