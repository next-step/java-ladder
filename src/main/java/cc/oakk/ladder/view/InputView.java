package cc.oakk.ladder.view;

import cc.oakk.ladder.view.printer.Printer;
import cc.oakk.ladder.view.printer.impl.StandardPrinter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    public static final String PERSON_DELIMITER = ",";
    public static final String RESULT_DELIMITER = ",";
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
        printHeader("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String line = scanner.nextLine();
        return line.split(PERSON_DELIMITER);
    }

    public String[] getResultNames(int exactSize) {
        printHeader("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] splited = scanner.nextLine().split(RESULT_DELIMITER);
        if (splited.length != exactSize) {
            throw new InputMismatchException(String.format("%d개를 입력해주세요.", exactSize));
        }
        return splited;
    }

    public int getLadderHeight() {
        printHeader("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    private void printHeader(String header) {
        stringPrinter.print(LINE_BREAK);
        stringPrinter.print(header);
        stringPrinter.print(LINE_BREAK);
    }

    public void printError(Throwable throwable) {
        stringPrinter.print("오류발생: " + throwable.getMessage() + LINE_BREAK);
    }
}
