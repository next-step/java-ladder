package view;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getParticipantsNames() {
        return scanner.nextLine();
    }

    @Override
    public int getHeightOfLadder() {
        return scanner.nextInt();
    }
}
