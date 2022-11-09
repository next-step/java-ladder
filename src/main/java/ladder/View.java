package ladder;

import java.util.List;

public class View {
    private final static String COLUMN = "|";
    private final static String ROW = "-";
    private final static String BLANK = " ";

    public void laddersView(Players players, int ladders) {
        List<Player> participants = players.getPlayers();

        boolean[] check = new boolean[ladders * participants.size()];

        for (int i = 0; i <= ladders; i++) {
            if (i == 0) {
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
            for (int j = 0; j < participants.size() - 1; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.print(ROW);
                }
                System.out.print(COLUMN);
            }
            System.out.println();
        }
    }
}
