package step2.view;

import step2.domain.Height;
import step2.domain.Users;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final String TEXT_INPUT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String TEXT_HIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String USER_DELIMETER = ",";

    public static final Scanner SCANNER = new Scanner(System.in);

    public Users inputUser() {
        System.out.println(TEXT_INPUT);
        String[] users = SCANNER.nextLine().split(USER_DELIMETER);
        return new Users(Arrays.stream(users).collect(Collectors.toList()));
    }

    public Height inputLadderHeight() {
        System.out.println(TEXT_HIGHT);
        int height = SCANNER.nextInt();
        return new Height(height);
    }

}
