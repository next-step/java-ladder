package ladder.io;


import java.util.List;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String DEFAULT_DELIMITER = ",";

    @Override
    public List<String> getNamesOfPlayersFromUser() {
        String[] namesOfPeople = SCANNER.nextLine().split(DEFAULT_DELIMITER);
        blankLine();
        return List.of(namesOfPeople);
    }

    @Override
    public List<String> getPlayResultsFromUser() {
        String[] playResults = SCANNER.nextLine().split(DEFAULT_DELIMITER);
        blankLine();
        return List.of(playResults);
    }

    @Override
    public int getHeightOfLadderFromUser() {
        String heightOfLadder = SCANNER.nextLine();
        blankLine();
        return toInt(heightOfLadder);
    }

    @Override
    public String getPlayerNameForResultFromUser() {
        return SCANNER.nextLine();
    }

    private void blankLine() {
        System.out.println();
    }

    private int toInt(String heightOfLadder) {
        return Integer.parseInt(heightOfLadder);
    }

}
