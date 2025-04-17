package ladder.view;

import ladder.domain.LadderHeight;
import ladder.domain.User;
import ladder.domain.Users;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Users getUsers() {
        String userInput = getStringInput("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<User> usersList = Arrays.stream(userInput.split(","))
                .map(String::trim)
                .map(User::new)
                .collect(Collectors.toList());
        return new Users(usersList);
    }

    public static LadderHeight getLadderHeight() {
        String userInput = getStringInput("최대 사다리 높이는 몇 개인가요?");
        return new LadderHeight(Integer.parseInt(userInput));
    }

    private static String getStringInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
