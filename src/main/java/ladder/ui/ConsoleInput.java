package ladder.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInput {

    private static final String SEPARATOR = ",";

    private ConsoleInput() {
        throw new AssertionError("ConsoleInput 클래스의 생성자를 호출할 수 없습니다.");
    }

    public static List<String> receiveNames() {
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 (%s)로 구분하세요)\n", SEPARATOR);
        String names = new Scanner(System.in).nextLine();
        return Arrays.stream(names.split(SEPARATOR))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static String receiveHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String height = new Scanner(System.in).nextLine();
        return height.trim();
    }
}
