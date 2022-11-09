package ladder;

import java.util.List;
import java.util.Random;

public class View {
    private final static String COLUMN = "|";
    private final static String ROW = "-";
    private final static String BLANK = " ";

    public void laddersView(Players players, int ladders) {
        List<Player> participants = players.getPlayers();

        boolean[][] check = new boolean[ladders][participants.size() - 1];

        for (int i = -1; i < ladders; i++) {
            if (i == -1) {
                for (Player participant : participants) {
                    System.out.print(participant.getName() + "\t");
                }
                System.out.println();
                continue;
            }
            for (int k = 0; k < participants.get(0).getName().length(); k++) {
                System.out.print(BLANK);
            }
            System.out.print(COLUMN);
            int randoms = new Random().nextInt(9) + 1;
            if (i == 0) {
                if (randoms > 4) {
                    for (int k = 0; k < 4; k++) {
                        System.out.print(ROW);
                    }
                    check[i][0] = true;
                    check[i + 1][0] = true;
                } else {
                    for (int k = 0; k < 4; k++) {
                        System.out.print(BLANK);
                    }
                }
            }
            if (i >= 1) {
                if (!check[i - 1][0]) {
                    for (int k = 0; k < 4; k++) {
                        System.out.print(ROW);
                    }
                    check[i][0] = true;
                } else {
                    for (int k = 0; k < 4; k++) {
                        System.out.print(BLANK);
                    }
                }
            }
            System.out.print(COLUMN);
            for (int j = 1; j < participants.size() - 1; j++) {
                if (!check[i][j - 1]) {
                    for (int k = 0; k < 4; k++) {
                        System.out.print(ROW);
                    }
                    check[i][j] = true;
                } else {
                    for (int k = 0; k < 4; k++) {
                        System.out.print(BLANK);
                    }
                }
                System.out.print(COLUMN);
            }
            System.out.println();
        }
    }
}
