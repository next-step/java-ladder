package ladder;

import java.util.List;
import java.util.Random;

public class View {
    private final static String COLUMN = "|";
    private final static String ROW = "-";
    private final static String BLANK = " ";
    private final static Random random = new Random();

    public void laddersView(Players players, int ladders) {
        List<Player> participants = players.getPlayers();

        boolean[][] check = new boolean[ladders][participants.size() - 1];

        for (int i = -1; i < ladders; i++) {
            if (i == -1) {
                printPlayersName(participants);
                continue;
            }
            makeTabByFirstPlayerName(participants.get(0).getName());
            int randoms = makeRandom();
            makeFirstSpace(check, i, randoms);
            makeSpaces(participants, check, i);
            System.out.println();
        }
    }

    private static void makeSpaces(List<Player> participants, boolean[][] check, int i) {
        for (int j = 1; j < participants.size() - 1; j++) {
            checkFrontSpace(check, i, j);
            System.out.print(COLUMN);
        }
    }

    private static void checkFrontSpace(boolean[][] check, int i, int j) {
        if (!check[i][j - 1]) {
            makeRow();
            check[i][j] = true;
        } else {
            makeBlank();
        }

    }

    private static void makeRow() {
        for (int k = 0; k < 4; k++) {
            System.out.print(ROW);
        }
    }

    private static void makeFirstSpace(boolean[][] check, int i, int randoms) {
        if (i == 0) {
            if (randoms > 4) {
                makeRow();
                check[i][0] = true;
                check[i + 1][0] = true;
            } else {
                makeBlank();
            }
        }
        if (i >= 1) {
            if (!check[i - 1][0]) {
                makeRow();
                check[i][0] = true;
            } else {
                makeBlank();
            }
        }
        System.out.print(COLUMN);
    }

    private static void makeBlank() {
        for (int k = 0; k < 4; k++) {
            System.out.print(BLANK);
        }
    }

    private static int makeRandom() {
        return random.nextInt(9) + 1;
    }

    private static void makeTabByFirstPlayerName(String player) {
        for (int k = 0; k < player.length(); k++) {
            System.out.print(BLANK);
        }
        System.out.print(COLUMN);
    }

    private static void printPlayersName(List<Player> participants) {
        for (Player participant : participants) {
            System.out.print(participant.getName() + "\t");
        }
        System.out.println();
    }
}
