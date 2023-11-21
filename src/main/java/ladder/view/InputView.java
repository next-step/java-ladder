package ladder.view;

import java.util.Scanner;

import ladder.domain.PersonNames;

import static ladder.view.inputParser.parse;

public class InputView {

    public static PersonNames inputNames() {
        Scanner scanner = new Scanner(System.in);
        return parse(scanner.nextLine());
    }
}
