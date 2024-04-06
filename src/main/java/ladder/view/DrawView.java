package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.domain.Participant;

import java.util.stream.Collectors;

public class DrawView {

    public static final int LADDER_WIDTH = 5;
    public static final String EXIST_MARK = "-";
    public static final String NON_EXIST_MARK = " ";
    public static final String PREFIX = "|";

    public void drawResult(LadderGame ladderGame) {
        System.out.println("실행결과");
        drawParticipants(ladderGame.getParticipant());
        drawLadder(ladderGame.getLadder());
    }

    public void drawParticipants(Participant participant) {
        System.out.println(participant.getNames().stream()
                .map(name -> String.format("%-" + 6 + "s", name))
                .collect(Collectors.joining())
        );
    }

    public void drawLadder(Ladder ladder) {
        ladder.getLines().stream()
                .map(Line::getLine)
                .forEach(line -> System.out.println(line.stream()
                        .map(this::drawPoint)
                        .collect(Collectors.joining()) + "|")
                );
    }

    public String drawPoint(boolean isExist) {
        if (isExist) {
            return PREFIX + EXIST_MARK.repeat(LADDER_WIDTH);
        }
        return PREFIX + NON_EXIST_MARK.repeat(LADDER_WIDTH);
    }
}
