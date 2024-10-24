package ladder.io;


import java.util.List;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String DEFAULT_DELIMITER = ",";

    @Override
    public List<String> getNamesOfPlayers() {
        String[] namesOfPeople = SCANNER.nextLine().split(DEFAULT_DELIMITER);
        blankLine();
        return List.of(namesOfPeople);
    }

    @Override
    public int getHeightOfLadder() {
        String heightOfLadder = SCANNER.nextLine();
        blankLine();
        return toInt(heightOfLadder);
    }

    private void blankLine() {
        System.out.println();
    }

    private int toInt(String heightOfLadder) {
        return Integer.parseInt(heightOfLadder);
    }

}
