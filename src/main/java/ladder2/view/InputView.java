package ladder2.view;

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
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return readLong();
    }

    private long readLong() {
        return Long.parseLong(scanner.nextLine());
    }

    public List<String> readName() {
        System.out.println();
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return toList(trimAll(scanner.nextLine()));
    }

    public List<String> readPrize() {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return toList(trimAll(scanner.nextLine()));
    }

    private String trimAll(String next) {
        return next.replace(" ", "");
    }

    private String[] split(String text) {
        return text.split(",");
    }

    private List<String> toList(String next) {
        return Arrays.stream(split(next))
                .collect(Collectors.toList());
    }

    public String resultType() {
        System.out.println();
        System.out.println("결과를 보고싶은 사람은?");
        return scanner.nextLine();
    }
}
