package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String[] inputPeople() {
        ResultView.printPeopleInputCommand();
        return nextLine().split(",");
    }

    public int inputMaxLadderHeight() {
        ResultView.printMaxLadderHeightInputCommand();
        return Integer.parseInt(nextLine());
    }

    private String nextLine() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }

}
