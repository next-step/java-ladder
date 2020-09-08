package cc.oakk.ladder.view;

import cc.oakk.ladder.view.printer.Printer;
import cc.oakk.ladder.view.printer.impl.StandardPrinter;

import java.util.Scanner;

public class InputView {
    public static final String PERSON_DELIMITER = ",";
    public static final String LINE_BREAK = System.lineSeparator();

    private final Scanner scanner;
    private final Printer<String> stringPrinter;

    public InputView() {
        this.stringPrinter = StandardPrinter.getInstance();
        this.scanner = new Scanner(System.in);
    }

    public InputView(Scanner scanner, Printer<String> stringPrinter) {
        this.scanner = scanner;
        this.stringPrinter = stringPrinter;
    }

    public String[] getPersonNames() {
        stringPrinter.print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)" + LINE_BREAK);
        String line = scanner.nextLine();
        return line.split(PERSON_DELIMITER);
    }

    public int getLadderHeight() {
        stringPrinter.print(LINE_BREAK);
        stringPrinter.print("최대 사다리 높이는 몇 개인가요?" + LINE_BREAK);

        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    public void printError(Throwable throwable) {
        stringPrinter.print("오류발생: " + throwable.getMessage() + LINE_BREAK);
    }
}
