package nextstep.ladder;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String[] inputNameList(String message) {
        System.out.println(message);
        String line = scanner.nextLine();
        return line.split(",");
    }

    public int inputInteger(String message) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }
}
