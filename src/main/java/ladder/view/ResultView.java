package ladder.view;

import ladder.model.Ladder;
import ladder.model.Line;
import ladder.model.Users;

public class ResultView {
    public void printResult(Users users, Ladder ladder) {
        System.out.println("실행 결과");
        System.out.println();
        printUserList(users);
        printLadder(ladder);
    }

    private void printUserList(Users users) {
        users.stream()
                .forEach(user -> System.out.printf("%-6s", user.getName()));
        System.out.println();
    }
    private void printLadder(Ladder ladder) {
        ladder.stream()
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
