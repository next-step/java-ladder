package nextstep.ladder.input;

import nextstep.ladder.domain.*;

import java.util.Scanner;

public class Input {
    private Input() {
        throw new IllegalStateException("Utility class");
    }

    public static UserNames inputNames() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String userNamesText = scanner.nextLine();

        return new UserNames(userNamesText);
    }

    public static LadderHeight inputLadderHeight() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = scanner.nextInt();

        return new LadderHeight(ladderHeight);
    }

    public static UserInput input() {
        UserNames userNames = inputNames();
        UserResults userResults = inputUserResults(userNames.size());
        LadderHeight ladderHeight = inputLadderHeight();

        return new UserInput(new UserData(userNames, userResults), ladderHeight);
    }

    private static UserResults inputUserResults(final int size) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String userResultsText = scanner.nextLine();

        return new UserResults(userResultsText, size);
    }

    public static String inputPrintUserName() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n결과를 보고 싶은 사람은?");
        String userName = scanner.nextLine();

        return userName;
    }
}
