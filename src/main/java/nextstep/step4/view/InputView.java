package nextstep.step4.view;

import nextstep.step4.domain.*;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_USER = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_MENTION = "결과를 보고 싶은 사람은?";
    private static final String ALL = "all";

    private static final int HEIGHT_LIMIT = 2;

    public GameCriteria getGameCriteria() {
        Users users = getUsers();
        Results results = getResults(users.getUserNumbers());

        return GameCriteria.of(users, results);
    }

    private Users getUsers() {
        System.out.println(INPUT_USER);
        return Users.initUsers(scanner.nextLine());
    }

    private Results getResults(int userNumbers) {
        System.out.println();
        System.out.println(INPUT_RESULT);
        return Results.initResults(userNumbers, scanner.nextLine());
    }

    public int getHeight() {
        System.out.println();
        System.out.println(INPUT_HEIGHT);
        int height = Integer.parseInt(scanner.nextLine());
        validateHeight(height);
        return height;
    }

    private void validateHeight(int height) {
        if(height < HEIGHT_LIMIT) {
            throw new IllegalArgumentException("높이는 2 이상이어야 합니다.");
        }
    }

    public String getResultUser(GameCriteria gameCriteria) {
        System.out.println();
        System.out.println();
        System.out.println(RESULT_MENTION);
        String resultUser = scanner.nextLine();
        if(resultUser.equals(ALL)) {
            return resultUser;
        }
        return validateUser(gameCriteria.getUserList(), resultUser);
    }

    private String validateUser(List<User> userList, String resultUser) {
        return userList.stream()
                .filter(user -> user.toString().equals(resultUser))
                .map(User::toString)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 참여자가 없습니다"));
    }
}
