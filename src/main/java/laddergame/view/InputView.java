package laddergame.view;

import laddergame.domain.utils.Constants;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static String getPlayerNames() {
        System.out.println(Constants.INPUT_PLAYER_NAMES);
        return scanner.nextLine();
    }

    public static int getMaxLadderHeight() {
        System.out.println("");
        System.out.println(Constants.INPUT_MAX_LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }

}
