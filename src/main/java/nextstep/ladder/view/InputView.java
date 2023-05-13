package nextstep.ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputPeople() {
        ResultView.printPeopleInputCommand();
        return new ArrayList<>(Arrays.asList(nextLine().split(",")));
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
