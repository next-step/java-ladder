package nextstep.ladder.view;

import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Users name() {
        while (true) {
            try {
                return new Users(makeUsers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<User> makeUsers() {
        String names;
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        names = SCANNER.next();
        String[] userNameList = names.split(",");
        List<User> users = new ArrayList<>();
        for (String userName : userNameList) {
            User user = new User(userName);
            users.add(user);
        }
        return users;
    }

    public static int ladderHeight() {
        int number;
        while (true) {
            try {
                System.out.println("최대 사다리 높이는 몇 개 인가요?");
                number = SCANNER.nextInt();
                return number;
            } catch (InputMismatchException e) {
                System.out.println("숫자가 아닌 값을 입력하였습니다");
                SCANNER.next();
            }
        }
    }
}
