package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    public List<String> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요.");

        return Arrays.stream(scanner.nextLine()
                .split(SEPARATOR))
                .collect(Collectors.toList());
    }

    public int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return scanner.nextInt();
    }
}
