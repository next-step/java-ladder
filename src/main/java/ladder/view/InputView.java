package ladder.view;

import ladder.domain.GoalsGenerator;
import ladder.domain.LadderGoals;
import ladder.domain.UserGenerator;
import ladder.domain.Users;

import java.util.Scanner;

public class InputView {
    public static final String USER_COUNT_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String HEIGHT_QUESTION = "최대 사다리 높이는 몇 개인가요?";
    public static final String LADDER_GOALS_QUESTION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String LADDER_WINNER_QUESTION = "결과를 보고 싶은 사람은?";
    private static Scanner scanner = new Scanner(System.in);

    public static Users askNumberOfUser() {
        System.out.println(USER_COUNT_QUESTION);
        return createUsers(scanner.nextLine());
    }

    public static int askLadderHeight() {
        System.out.println(HEIGHT_QUESTION);
        return Integer.parseInt(scanner.nextLine());
    }

    public static LadderGoals askLadderGoals() {
        System.out.println(LADDER_GOALS_QUESTION);
        return getResult(scanner.nextLine());
    }

    public static String askLadderWinner() {
        System.out.println(LADDER_WINNER_QUESTION);
        return new Scanner(System.in).nextLine();
    }

    private static Users createUsers(String user) {
        UserGenerator userGenerator = new UserGenerator(user);
        return new Users(userGenerator.generateUsers());
    }

    private static LadderGoals getResult(String result) {
        GoalsGenerator resultGenerator = new GoalsGenerator(result);
        return resultGenerator.generate();
    }

}
