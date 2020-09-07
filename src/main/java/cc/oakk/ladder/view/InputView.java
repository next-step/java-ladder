package cc.oakk.ladder.view;

import java.util.Scanner;

public class InputView {
    public static final String PERSON_DELIMITER = ",";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getPersonNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String line = scanner.nextLine();
        return line.split(PERSON_DELIMITER);
    }

    public int getLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    public void printError(Throwable throwable) {
        System.err.println("오류발생: " + throwable.getMessage() + "\n");
    }
}
