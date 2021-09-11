package step2.view;

import step2.dto.Height;
import step2.dto.Names;

import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public Names inputNames() {
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 쉼표(%s)로 구분하세요)\n", DELIMITER);
        final String s = scanner.nextLine();
        return new Names(s.split(DELIMITER));
    }

    public Height inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new Height(Integer.parseInt(scanner.nextLine()));
    }
}
