package nextstep.ladder.view;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

public class InputView {
    private static final String SPLIT_TEXT = ",";
    private static final String ALL = "all";
    private static Scanner scanner = new Scanner(System.in);

    public static String[] enterUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return splitByComma(scanner.nextLine());
    }

    public static int enterLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static String[] enterResults() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return splitByComma(scanner.nextLine());
    }

    private static void validateUserNames(String names) {
        if (names == null || names.isEmpty() || ALL.equals(names)) {
            throw new IllegalArgumentException("이름을 빈값이나 all 로 입력하였습니다. 이름을 입력해주세요.");
        }
    }

    public static String[] splitByComma(String userNames) {
        validateUserNames(userNames);
        return userNames.split(SPLIT_TEXT);
    }
}
