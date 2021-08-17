package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readNames() {
        String raw = nextLineWhileEmpty("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return Arrays.stream(raw.split(",")).map(String::trim).collect(Collectors.toList());
    }

    public static int readHeight() {
        String raw = nextLineWhileEmpty("최대 사다리 높이는 몇 개인가요?");

        return Integer.parseInt(raw);
    }

    private static String nextLineWhileEmpty(String message) {
        String raw = null;
        while (raw == null || raw.isEmpty()) {
            System.out.println(message);
            raw = scanner.nextLine();
        }
        return raw;
    }
}
