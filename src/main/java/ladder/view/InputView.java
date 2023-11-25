package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public long readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return readLong();
    }

    private long readLong() {
        return Long.parseLong(scanner.nextLine());
    }

    public List<String> readName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String next = scanner.nextLine();
        next = trimAll(next);

        return Arrays.stream(split(next))
                .collect(Collectors.toList());
    }

    private String[] split(String text) {
        return text.split(",");
    }

    private String trimAll(String next) {
        return next.replace(" ", "");
    }
}
