package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PERSON_SEPARATOR = ",";

    private MessagePrinter messagePrinter;

    public InputView() {
        this.messagePrinter = new MessagePrinter();
    }

    public String[] inputPersonNames() {
        messagePrinter.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] personNames = scanner.nextLine().split(PERSON_SEPARATOR);
        return personNames;
    }

    public int inputLadderHeight() {
        messagePrinter.println(System.lineSeparator() + "최대 사다리 높이는 몇 개 인가요?");
        return scanner.nextInt();
    }
}
