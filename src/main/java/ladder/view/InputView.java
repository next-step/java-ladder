package ladder.view;

import ladder.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Users getUsers() {
        String userInput = getStringInput("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> usersList = mapStringToList(userInput);
        return new Users(usersList);
    }

    public static Results getResults() {
        String userInput = getStringInput("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<String> resultsList = mapStringToList(userInput);
        return new Results(resultsList);
    }

    public static LadderHeight getLadderHeight() {
        String userInput = getStringInput("최대 사다리 높이는 몇 개인가요?");
        return new LadderHeight(Integer.parseInt(userInput));
    }

    public static User getTargetUser() {
        String userInput = getStringInput("결과를 알고 싶은 사람은?");
        return new User(userInput);
    }

    private static List<String> mapStringToList(String userInput) {
        return Arrays.stream(userInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static String getStringInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
