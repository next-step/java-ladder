package ladder.view;

import ladder.domain.Entry;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static Entry inputEntry() {
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 쉼표(%s)로 구분하세요)%n", DELIMITER);
        return Entry.valueOf(scanner.nextLine().split(DELIMITER));
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
