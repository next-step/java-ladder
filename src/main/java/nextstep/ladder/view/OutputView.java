package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final int MAX_LADDER_WIDTH = 5;
    public static final String LADDER_BLANK_LINE = " ".repeat(MAX_LADDER_WIDTH);
    public static final String LADDER_ROW_LINE = "-".repeat(MAX_LADDER_WIDTH);
    public static final String LADDER_COLUMN_LINE = "|";

    public void printUserNameList(Users users) {
        for (User user : users.getUserList()) {
            System.out.print(getLadderSizeName(user));
            System.out.print(" ");
        }
        System.out.println();
    }

    public void printResultList(Ladder ladder) {
        ladder.getResult().forEach(result -> {
            System.out.print(getLadderSizeResult(result));
            System.out.print(" ");
        });
        System.out.println();
    }

    public void printLadder(Ladder ladder){
        stringLadder(ladder).forEach(System.out::println);
        this.printResultList(ladder);
    }

    public List<String> stringLadder(Ladder ladder) {
        return ladder.lines().stream()
                .map(this::printLine)
                .collect(Collectors.toList());
    }

    private String printLine(Line line) {
        StringBuilder ladderLine = new StringBuilder(LADDER_BLANK_LINE+LADDER_COLUMN_LINE);
        line.points().forEach(point ->  {
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
        System.out.println(ladder.getLadderResult(users.positionUserName(name)));
    }
}
