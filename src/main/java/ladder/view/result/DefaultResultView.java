package ladder.view.result;

import ladder.domain.model.LadderLine;
import ladder.domain.model.LadderLines;
import ladder.view.input.Users;

public class DefaultResultView implements ResultView {
    public void print(Users users, LadderLines ladderLines) {
        System.out.println("\n실행결과\n");
        printUsers(users);
        printLadder(ladderLines);
    }

    private void printUsers(Users users) {
        users.getUserNames().stream()
                .map(user -> String.format("%6s", user))
                .forEach(System.out::print);
        System.out.println();
    }

    private void printLadder(LadderLines ladderlines) {
        ladderlines.get()
                .forEach(this::printLine);
    }

    private void printLine(LadderLine ladderLine) {
        System.out.print("     ");
        ladderLine.getLines()
                .forEach(point -> printLine(point.isRight()));
        System.out.println();
    }

    private void printLine(boolean existLine) {
        System.out.print("|");
        if (existLine) {
            System.out.print("-----");
            return;
        }
        System.out.print("     ");
    }
}
