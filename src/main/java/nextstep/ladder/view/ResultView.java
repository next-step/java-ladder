package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Direction;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.user.User;

import java.util.List;

public class ResultView {

    private static final int ROW_INTERVAL = 5;
    private static final String ALL = "all";

    public static void printNames(List<String> names) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
        names.stream()
                .forEach(name -> {
                    System.out.printf(String.format("%-5s",name));
                });
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        for (int indexOfHeight = 0; indexOfHeight < ladder.getHeight(); indexOfHeight++) {
            searchRowLine(ladder, indexOfHeight);
            System.out.println();
        }
    }

    private static void searchRowLine(Ladder ladder, int indexOfHeight) {
        for (int indexOfLine = 0; indexOfLine < ladder.getLines().size(); indexOfLine++) {
            System.out.print("|");
            isExistRowLine(ladder, indexOfHeight, indexOfLine);
        }
    }

    private static void isExistRowLine(Ladder ladder, int indexOfHeight, int lineIndex) {
        if (ladder.getLines()
                .get(lineIndex)
                .isEqualsPointOfDirection(indexOfHeight, Direction.RIGHT)) {
            printRow();
            return;
        }
        printEmpty();
    }

    private static void printEmpty() {
        for (int i = 0; i < ROW_INTERVAL; i++) {
            System.out.print(" ");
        }
    }

    private static void printRow() {
        for (int i = 0; i < ROW_INTERVAL; i++) {
            System.out.print("-");
        }
    }

    public static void printResults(List<String> results) {
        results.stream()
                .forEach(result -> {
                    System.out.printf(String.format("%-5s",result));
                });
        System.out.println();
    }

    public static void printFindResult(String findResultName, List<User> users, Ladder ladder) {
        validateFindResultName(findResultName,users);
        System.out.println();
        System.out.println("실행 결과");
        if (ALL.equals(findResultName)) {
            users.stream()
                    .forEach(user -> {
                        System.out.println(user.getName() + " : " + ladder.getResultOfLine(user.getIndexOfColumnLine()));
                    });
            return;
        }
        users.stream()
                .filter(user -> user.getName().equals(findResultName))
                .forEach(user -> {
                    System.out.println(ladder.getResultOfLine(user.getIndexOfColumnLine()));
                    System.out.println();
                });
    }

    private static void validateFindResultName(String findResultName, List<User> users) {
        if (findResultName == null || "".equals(findResultName)) {
            throw new IllegalArgumentException("결과를 보고 싶은 사람은 null 또는 빈값을 입력할 수 없습니다.");
        }
        users.stream()
                .filter(user -> user.getName().equals(findResultName) || ALL.equals(findResultName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("결과를 보고 싶은 사람은 참여할 사람중에 있어야 합니다."));
    }
}
