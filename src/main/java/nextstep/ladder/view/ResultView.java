package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Users;

public class ResultView {
    public void printResult(Users userList, Ladder ladder) {
        System.out.println("실행 결과");
        System.out.println();
        printUserList(userList);
        printLadder(ladder);
    }

    private void printUserList(Users users) {
        users.getUsers().stream()
                .forEach(user -> System.out.printf("%-6s", user.getName()));
        System.out.println();
    }
    private void printLadder(Ladder ladder) {
        ladder.getLines().stream()
                .forEach(this::printLine);
    }

    private void printLine(Line line) {
        System.out.print("|");
        for (int i = 0; i < line.size() - 1; ++i) {
            if (line.getPoint(i)) {
                System.out.print("-----");
            } else {
                System.out.print("     ");
            }

            System.out.print("|");
        }
        System.out.println();
    }
}
