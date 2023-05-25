package nextstep.ladder;

import java.util.Scanner;

public class LadderView {
    public Users getUsers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        var userInput = new UsersInput(getConsoleInput());
        return userInput.toUsers();
    }

    public Natural getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        var naturalInput = new NaturalInput(getConsoleInput());
        return naturalInput.toNatural();
    }

    public void printResults(Ladder ladder) {
        System.out.println("실행결과");

        ladder.users.forEach(user -> System.out.printf("%s\t", user));
        printNewLine();
        for (var level = ladder.height.value() - 1; level >= 0; level--) {
            printLevel(level, ladder);
        }
    }

    private static void printLevel(long level, Ladder ladder) {
        for (var place = 0; place < ladder.users.size().value() - 1; place++) {
            printColumn();
            printLegIfExistsInLadder(new Position(level, place), ladder);
        }
        printColumn();
        printNewLine();
    }

    private static void printNewLine() {
        System.out.println();
    }

    private static void printColumn() {
        System.out.print("|");
    }

    private static void printLegIfExistsInLadder(Position position, Ladder ladder) {
        if (ladder.legs.hasLegOnRightSideOf(position)) {
            printFilledLeg();
            return;
        }
        printEmptyLeg();
    }

    private static void printEmptyLeg() {
        System.out.print("     ");
    }

    private static void printFilledLeg() {
        System.out.print("-----");
    }

    private String getConsoleInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
