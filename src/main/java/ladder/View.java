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
            for (int j = 1; j < participants.size(); j++) {
                int random = new Random().nextInt(9) + 1;
                if (j == participants.size() - 1) {
                    if (!check[i][participants.size() - 3]) {
                        for (int k = 0; k < 4; k++) {
                            System.out.print(ROW);
                        }
                        check[i][participants.size() - 2] = true;
                    } else {
                        for (int k = 0; k < 4; k++) {
                            System.out.print(BLANK);
                        }
                    }
                    System.out.print(COLUMN);
                    break;
                }
                if (!check[i][0]) {
                    for (int k = 0; k < 4; k++) {
                        System.out.print(ROW);
                    }
                    System.out.print(COLUMN);
                    check[i][0] = true;
                    continue;
                }
                if (random > 4) {
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
