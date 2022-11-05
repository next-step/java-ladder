package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Lines;
import nextstep.ladder.model.Players;

import java.util.List;

public class Output {
    private Output() {
    }

    public static void outputResult(Ladder ladder, Players players){
        System.out.println(players);
        List<Lines> lines = ladder.getLines();
        for (Lines line : lines) {
            System.out.print("|");
            System.out.print(line);
            System.out.println();
        }
    }
}
