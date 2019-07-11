package ladder.view.result;

import ladder.common.Csv;
import ladder.domain.ladderline.LadderLine;
import ladder.domain.ladderline.LadderLines;
import ladder.domain.user.LadderResult;
import ladder.domain.user.LadderUsers;

public class DefaultResultView implements ResultView {

    @Override
    public void print(LadderUsers ladderUsers, LadderLines ladderLines, Csv ladderResults) {
        System.out.println("\n사다리 결과\n");
        printUsers(ladderUsers);
        printLadder(ladderLines);
        printResults(ladderResults);
    }

    private void printUsers(LadderUsers ladderUsers) {
        ladderUsers.getUsernames().stream()
                .map(user -> String.format("%6s", user))
                .forEach(System.out::print);
        System.out.println();
    }

    private void printLadder(LadderLines ladderlines) {
        ladderlines.get()
                .forEach(this::printLine);
    }

    private void printResults(Csv ladderResults) {
        ladderResults.getCsv().stream()
                .map(result -> String.format("%6s", result))
                .forEach(System.out::print);
        System.out.println();
    }

    private void printLine(LadderLine ladderLine) {
        System.out.print("     ");
        ladderLine.get()
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

    @Override
    public void print(LadderResult ladderResult) {
        System.out.println("\n실행 결과");
        if (ladderResult.isOneUser()) {
            System.out.println(ladderResult.getResultOne());
            return;
        }
        printResultAll(ladderResult);
    }
    private void printResultAll(LadderResult ladderResult) {
        ladderResult.findAll().entrySet().stream()
                .forEach(entry -> System.out.println(String.format("%s : %s", entry.getKey().getUsername(), entry.getValue())));
    }
}
