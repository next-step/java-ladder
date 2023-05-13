package nextstep.ladder.view;

import nextstep.ladder.domain.People;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public People people() {
        ResultView.printPeopleInputCommand();
        return new People(nextLine().split(","));
    }

    public int height() {
        ResultView.printHeightInputCommand();
        return Integer.parseInt(nextLine());
    }

    private String nextLine() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }

}
