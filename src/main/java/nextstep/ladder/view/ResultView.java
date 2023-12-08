package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participants;

public class ResultView {
    private static final String LINE = "|";
    private static final String LADDER_LINE = "-----";
    private static final String LADDER_EMPTY = "     ";
    private static final String RESULT_PLAY = "\n실행결과\n";

    public void ladderView(Ladder ladder, Participants participants) {
        System.out.println(RESULT_PLAY);

        participants.getParticipants().forEach(p -> {
            int spacesToAdd = 6 - p.getParticipant().length();
            System.out.print(p.getParticipant() + " ".repeat(spacesToAdd));
        });
        System.out.println();
        ladder.getLines().forEach(this::drawLadder);
    }

    private void drawLadder(Line line) {
        System.out.print(LINE);
        line.getPoints()
                .forEach(b -> {
                    if (b.getPoint()) {
                        System.out.print(LADDER_LINE + LINE);
                    } else {
                        System.out.print(LADDER_EMPTY + LINE);
                    }
                });
        System.out.print("\n");
    }
}
