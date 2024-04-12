package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.LadderGame;
import ladder.domain.participants.Name;
import ladder.domain.participants.Participants;
import ladder.domain.result.GameResult;
import ladder.domain.result.Records;

import java.util.stream.Collectors;

public class DrawView {

    public static final int LADDER_WIDTH = 5;
    public static final String EXIST_MARK = "-";
    public static final String NON_EXIST_MARK = " ";
    public static final String PREFIX = "|";

    public void drawLadder(LadderGame ladderGame, GameResult results) {
        System.out.println("사다리 결과");
        drawParticipants(ladderGame.getParticipant());
        drawLine(ladderGame.getLadder());
        drawResult(results);
    }

    private void drawParticipants(Participants participants) {
        System.out.println(participants.getGamers().stream()
                .map(gamer -> String.format("%-" + 6 + "s", gamer.getName()))
                .collect(Collectors.joining())
        );
    }

    private void drawLine(Ladder ladder) {
        ladder.getLines().stream()
                .map(Line::getLine)
                .forEach(line -> System.out.println(line.stream()
                        .map(this::drawPoint)
                        .collect(Collectors.joining()) + "|")
                );
    }

    private String drawPoint(boolean isExist) {
        if (isExist) {
            return PREFIX + EXIST_MARK.repeat(LADDER_WIDTH);
        }
        return PREFIX + NON_EXIST_MARK.repeat(LADDER_WIDTH);
    }

    private void drawResult(GameResult results) {
        System.out.println(results.getRewords().stream()
                .map(reword -> String.format("%-" + 6 + "s", reword.getItem()))
                .collect(Collectors.joining()));
    }

    public void drawGameRecords(Name targetName, Records gameRecords) {
        if (targetName.equals(new Name("all"))) {
            drawGameRecords(gameRecords);
        }
        drawGameRecords(gameRecords.find(targetName));
    }

    private void drawGameRecords(Records record) {
        System.out.println("실행 결과");
        record.getRewardGamers()
                .forEach(e -> System.out.println(
                        String.format("%s : %s", e.getGamer().getName(), e.getReword().getItem())
                ));
    }
}
