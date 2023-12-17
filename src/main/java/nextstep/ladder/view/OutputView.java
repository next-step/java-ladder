package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final int MAX_LADDER_WIDTH = 5;
    public static final String LADDER_BLANK_LINE = " ".repeat(MAX_LADDER_WIDTH);
    public static final String LADDER_ROW_LINE = "-".repeat(MAX_LADDER_WIDTH);
    public static final String LADDER_COLUMN_LINE = "|";
    private final Output output;


    public OutputView(Output output) {
        this.output = output;
    }

    public void printUserNameList(Users users) {
        output.printf("사다리 결과 %n%n");
        for (User user : users.getUserList()) {
            output.print(getLadderSizeName(user));
            output.print(" ");
        }
        output.println("");
    }

    public void printResultList(Ladder ladder) {
        ladder.getResult().forEach(result -> {
            output.print(getLadderSizeResult(result));
            output.print(" ");
        });
        output.println("");
    }

    public void printLadder(Ladder ladder) {
        stringLadder(ladder).forEach(output::println);
        this.printResultList(ladder);
    }

    public List<String> stringLadder(Ladder ladder) {
        return ladder.lines().stream()
                .map(this::printLine)
                .collect(Collectors.toList());
    }

    private String printLine(Line line) {
        StringBuilder ladderLine = new StringBuilder(LADDER_BLANK_LINE + LADDER_COLUMN_LINE);
        line.points().forEach(point -> {
            ladderLine.append(point ? LADDER_ROW_LINE : LADDER_BLANK_LINE);
            ladderLine.append(LADDER_COLUMN_LINE);
        });
        return ladderLine.toString();
    }

    private String getLadderSizeName(User user) {
        String name = user.name();
        int length = name.length();
        if (length == MAX_LADDER_WIDTH) {
            return name;
        }
        return " ".repeat(MAX_LADDER_WIDTH - length) + name;
    }

    private String getLadderSizeResult(String result) {
        int length = result.length();
        if (length == MAX_LADDER_WIDTH) {
            return result;
        }
        return " ".repeat(MAX_LADDER_WIDTH - length) + result;
    }

    public void printResult(Ladder ladder, Users users, String name) {
        System.out.println("실행 결과");
        if (name.equals("all")) {
            ladder.getLadderAllResult(users).getMap().forEach((key, result) -> {
                System.out.printf("%s : %s%n", key, result);
            });
            return;
        }
        System.out.println(ladder.getLadderResult(users.positionUserName(name)));

    }
}
