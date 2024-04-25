package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Participates;

public class OutputView {

    private final String WRAPPER = "|";
    private final String LADDERLINE = "-----";
    private final String EMPTYSPACE = "     ";

    public void showParticipate(Participates participates) {
        System.out.println("실행결과");
        participates.getParticipates()
            .forEach(participate -> System.out.print(participate + "  "));
        System.out.println();
    }

    public void showLadder(Ladder ladder) {
        ladder.getLines().forEach(line -> {
            System.out.print(WRAPPER);
            showLine(line);
            System.out.println();

        });

    }

    private void showLine(Line line) {
        line.getPoints().stream()
            .map(result -> result ? LADDERLINE + WRAPPER : EMPTYSPACE + WRAPPER)
            .forEach(System.out::print);
    }

}
