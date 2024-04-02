package nextstep.ladder.view;

import nextstep.ladder.Ladder;
import nextstep.ladder.Line;

import java.util.List;

public class OutputView {

    public void printLadder(Ladder ladder) {
        System.out.println(renderLine(ladder));
    }

    private String renderLine(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        for (Line line : ladder.getLines()) {
            sb.append(renderPoints(line.getPoints()));
            sb.append("|\n");
        }
        return sb.toString();
    }

    private String renderPoints(List<Boolean> points) {
        StringBuilder sb = new StringBuilder();
        for (Boolean point : points) {
            sb.append("|");
            if (point) {
                sb.append("-----");
            } else {
                sb.append("     ");
            }
        }
        return sb.toString();
    }

}
