package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class DrawView {

    public static final int LADDER_WIDTH = 5;
    public static final String EXIST_MARK = "-";
    public static final String NON_EXIST_MARK = " ";
    public static final String PREFIX = "|";

    public void drawLadder(LadderGame ladderGame, GameResult results) {
        System.out.println("실행결과");
        drawParticipants(ladderGame.getParticipant());
        drawLine(ladderGame.getLadder());
        drawResult(results);
    }

    public void drawParticipants(Participants participants) {
        System.out.println(participants.getNames().stream()
                .map(name -> String.format("%-" + 6 + "s", name))
                .collect(Collectors.joining())
        );
    }

    public void drawLine(Ladder ladder) {
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

    private void drawResult(GameResult results) {
        System.out.println(results.getRewords().stream()
                .map(reword -> String.format("%-" + 6 + "s", reword))
                .collect(Collectors.joining()));
    }

    public void drawGameResult(List<Gamer> gamers) {
        System.out.println(gamers.stream()
                .map(gamer -> String.format("%-" + 6 + "s", gamer.getName()))
                .collect(Collectors.joining()));
    }
}
