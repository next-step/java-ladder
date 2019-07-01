package ladder.view.input;

import ladder.core.view.input.Inputor;

import java.util.Scanner;

public class ConsoleInputor implements Inputor {
    private static final Scanner SCANNER = new Scanner(System.in);
    
    @Override
    public String inputString() {
        return SCANNER.nextLine();
    }
    
    @Override
    public int inputNumber() {
        int number = SCANNER.nextInt();
        SCANNER.nextLine();
        return number;
    }
}
