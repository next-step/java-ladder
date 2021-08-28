package ladder.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String VALID_DELIMITER = ",";

    public String[] requestName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(" + VALID_DELIMITER + ")로 구분하세요)");
        return scanner.nextLine().split(VALID_DELIMITER);
    }

    public int requestHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
