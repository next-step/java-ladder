package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    public List<String> names() {
        System.out.println("참여할 사람 이름을 입력하세요.");
        return inputString();
    }

    public List<String> results() {
        System.out.println("실행 결과를 입력하세요.");
        return inputString();
    }

    public int height() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public String person() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

    private List<String> inputString() {
        return Arrays.stream(scanner.nextLine()
                .split(SEPARATOR))
                .collect(Collectors.toList());
    }
}
