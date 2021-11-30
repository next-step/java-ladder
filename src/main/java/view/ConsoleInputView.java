package view;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String getParticipantsNames() {
        return scanner.nextLine();
    }

    @Override
    public String getLadderResult() {
        return scanner.nextLine();
    }

    @Override
    public int getHeightOfLadder() {
        return scanner.nextInt();
    }

    @Override
    public String getParticipantForResult() {
        return scanner.nextLine();
    }
}
