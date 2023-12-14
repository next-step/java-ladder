package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private final Input input;

    public InputView(Input input) {
        this.input = input;
    }

    public String[] inputStringList(String message) {
        System.out.println(message);
        String line = input.nextLine();
        return line.split(",");
    }

    public int inputInteger(String message) {
        System.out.println(message);
        return input.nextInt();
    }

    public String inputString(String message) {
        System.out.println(message);
        return input.nextLine();
    }
}
