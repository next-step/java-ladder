package nextstep.ladder;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String[] inputNameList(String name) {
        String line = scanner.nextLine();
        return line.split(",");
    }

    public int inputInteger() {
        return Integer.parseInt(scanner.nextLine());
    }
}
