package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> inputUserNames() {
        System.out.println("참여할 사람의 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return Arrays.stream(scanner.nextLine().split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    }

    public static Integer inputLadderHeight() {
        System.out.println("최대 사라리 높이는 몇 개인가요?");

        return scanner.nextInt();
    }
}
