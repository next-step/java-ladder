package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getParticipants() {
        return scanner.next();
    }
    
    public static int getLadderHeight() {
        return scanner.nextInt();
    }
}
