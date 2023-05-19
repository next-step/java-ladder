package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.ResultInput;
import ladder.domain.ResultUsers;
import ladder.domain.User;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String BLANK = "";
    private static final String VERTICAL_LINE_STRING = "|";
    private static final String HORIZONTAL_LINE_STRING = "-";

    public void printLadder(Ladder ladder, ResultInput resultInput) {
        System.out.println(RESULT_MESSAGE);
        System.out.println();

        printParticipants(ladder.getUserNames());
        IntStream.range(0, ladder.height())
                .forEach(i -> printLine(ladder.hasRightConnections(i)));
        printInputResults(resultInput);
    }

    private void printParticipants(List<String> names) {
        for (String name : names) {
            System.out.printf("%6s", name);
        }
        System.out.println();
    }

    private void printLine(List<Boolean> rightConnections) {
        System.out.printf("%6s", VERTICAL_LINE_STRING);
        IntStream.range(0, rightConnections.size() - 1)
                .mapToObj(i -> rightConnections.get(i) ? HORIZONTAL_LINE_STRING.repeat(5) : BLANK)
                .forEach(line -> System.out.printf("%5s%1s", line, VERTICAL_LINE_STRING));
        System.out.println();
    }

    public void printInputResults(ResultInput resultInput) {
        int size = resultInput.size();
        IntStream.range(0, size)
                .forEach(i -> System.out.printf("%6s", resultInput.getResultByPosition(i)));
        System.out.println();
    }

    public void printUserResult(User user, ResultUsers resultUsers) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(resultUsers.getResultByUser(user));
        System.out.println();
    }

    public void printAllResult(ResultUsers resultUsers) {
        System.out.println(RESULT_MESSAGE);

        resultUsers.getUserNames()
                .forEach(userName -> {
                    System.out.printf("%s : ", userName);
                    System.out.println(resultUsers.getResultByUser(userName));
                });
        System.out.println();
    }
}
