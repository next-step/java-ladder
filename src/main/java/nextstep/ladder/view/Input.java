package nextstep.ladder.view;

import java.util.Scanner;

public class Input {

    private static Scanner SCANNER = new Scanner(System.in);

    public static String InputParticipants() {
        return SCANNER.nextLine();
    }
}
