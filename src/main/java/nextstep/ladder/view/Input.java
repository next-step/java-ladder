package nextstep.ladder.view;

import java.util.Scanner;

public class Input {

    private final Scanner scanner = new Scanner(System.in);
    public Input() {
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public int nextInt() {
        return Integer.parseInt(scanner.nextLine());
    }

}
