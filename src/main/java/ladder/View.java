package ladder;

import java.util.List;
import java.util.Random;

public class View {
    private final static String COLUMN = "|";
    private final static String ROW = "-";
    private final static String BLANK = " ";

    public void laddersView(Players players, int ladders) {
        List<Player> participants = players.getPlayers();

        boolean[] check = new boolean[ladders * participants.size()];

        for (int i = 1; i <= ladders * participants.size(); i++) {
            if (new Random().nextInt(9) < 4) {
                for (int j = 0; j < 4; j++) {
                    if (!check[i - 1]) {
                        System.out.print(BLANK);
                        check[i] = !check[i];
                    }
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    System.out.print(ROW);
                    check[i] = true;
                }
            }

            if (i % participants.size() == 0) {
                System.out.print(COLUMN);
                System.out.println();
                continue;
            }
            System.out.print(COLUMN);
        }
    }
}
