package nextstep.ladder.view;

import nextstep.ladder.model.Label;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";
    public static final Label EXIT = new Label("exit");

    public static String[] readNames() {
        String raw = nextLineWhileEmpty("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return Arrays.stream(raw.split(DELIMITER))
            .map(String::trim)
            .toArray(String[]::new);
    }

    public static String[] readResults() {
        String raw = nextLineWhileEmpty("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        return Arrays.stream(raw.split(DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
    }

    public static int readHeight() {
        String raw = nextLineWhileEmpty("최대 사다리 높이는 몇 개인가요?");

        return Integer.parseInt(raw);
    }

    public static String readName() {
        String raw = nextLineWhileEmpty("결과를 보고 싶은 사람은? (종료는 "  + EXIT + ", 모두 보고 싶으면 all)");

        return raw.trim();
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