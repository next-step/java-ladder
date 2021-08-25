package nextstep.ladder.step2.view;

import nextstep.ladder.step2.domain.Ladder;
import nextstep.ladder.step2.domain.Line;
import nextstep.ladder.step2.domain.Name;
import nextstep.ladder.step2.domain.Player;

public class ResultView {
    private static final String EMPTY_LINE = "     |";
    private static final String HORIZONTAL_LINE = "-----|";
    private static final String RESULT_MESSAGE = "실행결과";

    public static void printLadderGame(Player players, Ladder ladder) {
        System.out.println(RESULT_MESSAGE);
        for (Name name : players.getPlayers()) {
            System.out.print(String.format("%6s",name));
        }
        System.out.println();
        StringBuilder sb = new StringBuilder();
        for (Line line : ladder.getLines()) {
            for (boolean point : line.getPoints()){
                if (point){
                   sb.append(HORIZONTAL_LINE);
                }else {
                    sb.append(EMPTY_LINE);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
