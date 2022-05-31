package ladder.ui;

import java.util.Scanner;

public class LadderScanner {
    public static Scanner scanner = new Scanner(System.in);

    public static String insertParticipant() {
        InputView.printInsertParticipantPhrase();
        return scanner.nextLine();
    }

    public static int insertLadderHeight() {
        InputView.printInsertLadderHeightPhrase();
        return Integer.parseInt(scanner.nextLine());
    }
}