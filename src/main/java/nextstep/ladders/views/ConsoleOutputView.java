package nextstep.ladders.views;

import nextstep.ladders.domain.Ladder;
import nextstep.ladders.domain.Line;
import nextstep.ladders.domain.Lines;

public class ConsoleOutputView {

    public void print(Ladder ladder) {
        Lines lines = ladder.getLines();
        for (Line line : lines.getLines()) {
            extracted(line);
        }
    }

    private void extracted(Line line) {
        for (Boolean point : line.getPoints()) {
            if (point) {
                System.out.print("-----|");
            } else {
                System.out.print("     |");
            }
        }
        System.out.println();
    }
}
