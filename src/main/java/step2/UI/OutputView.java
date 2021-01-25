package step2.UI;

import step2.Ladder;
import step2.Player;
import step2.Players;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE ="실행결과";
    private static final String LADDER_HEIGHT_DRAWING = "|";
    private static final String LADDER_LINE_DRAWING = "-----";
    private static final String LADDER_NO_LINE_DRAWING = "     ";
    private static final String BLANK = " ";

    public static void outputView(Ladder ladder, List<Player> players) {
        System.out.println(RESULT_MESSAGE);

        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
            int nameLength = 5 - player.getName().length();
            String name = player.getName();

            sb.append(name);

            if (nameLength != 0) {
                for (int i = 0; i < nameLength; i++) {
                    sb.append(BLANK);
                }
            }

        }
        System.out.println(sb);

        for (int i = 0; i < ladder.size(); i++) {
            // 라인
            sb = new StringBuilder();
            sb.append(LADDER_HEIGHT_DRAWING);
            for (Boolean point : ladder.getLadder().get(i).getPoints()) {
                if (point) {
                    sb.append(LADDER_LINE_DRAWING);
                } else {
                    sb.append(LADDER_NO_LINE_DRAWING);
                }
                sb.append(LADDER_HEIGHT_DRAWING);
            }

            System.out.println(sb);
        }
    }
}
