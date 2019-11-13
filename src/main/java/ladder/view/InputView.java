package ladder.view;

import ladder.util.Parser;
import ladder.util.StringUtils;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static List<String> createUsers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputValue = scanner.next();

        List<String> users = Parser.convertToList(inputValue);
        checkUsers(users);
        return users;
    }
    private static void checkUsers(List<String> users) {
        if(isInvalid(users)) {
            throw new IllegalArgumentException("이름은 5자 이내로 입력해주세요.");
        }
    }

    public static List<String> createOutcomes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String inputValue = scanner.next();

        List<String> outcomes = Parser.convertToList(inputValue);
        return outcomes;
    }

    private static boolean isInvalid(List<String> users) {
        return users.stream()
                .anyMatch(InputView::isInvalidCondition);
    }

    private static boolean isInvalidCondition(String s) {
        return StringUtils.isEmpty(s) || s.length() > 5;
    }

    public static int createLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
