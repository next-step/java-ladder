package ladder.view;

import ladder.domain.ladders.ladder.Ladder;
import ladder.domain.ladders.LadderGame;
import ladder.domain.ladders.ladder.Line;
import ladder.domain.participants.Name;
import ladder.domain.participants.Participants;
import ladder.domain.ladders.reward.GameRewards;
import ladder.domain.result.GameRecords;
import ladder.domain.result.RewardResult;

import java.util.List;
import java.util.stream.Collectors;

public class DrawView {

    public static final int LADDER_WIDTH = 5;
    public static final String EXIST_MARK = "-";
    public static final String NON_EXIST_MARK = " ";
    public static final String SUFFIX = "|";

    public void drawLadder(LadderGame ladderGame, Participants participants) {
        System.out.println("사다리 결과");
        drawParticipants(participants);
        drawLine(ladderGame.getLadder());
        drawResult(ladderGame.getGameRewards());
    }

    private void drawParticipants(Participants participants) {
        System.out.println(participants.getGamers().stream()
                .map(gamer -> String.format("%" + 6 + "s", gamer.getName()))
                .collect(Collectors.joining())
        );
    }

    private void drawLine(Ladder ladder) {
        ladder.getLines().stream()
                .map(Line::getLine)
                .forEach(line -> System.out.println(line.stream()
                        .map(this::drawPoint)
                        .collect(Collectors.joining()))
                );
    }

    private String drawPoint(boolean isExist) {
        if (isExist) {
            return EXIST_MARK.repeat(LADDER_WIDTH) + SUFFIX;
        }
        return NON_EXIST_MARK.repeat(LADDER_WIDTH) + SUFFIX;
    }

    private void drawResult(GameRewards results) {
        System.out.println(results.getRewords().stream()
                .map(reword -> String.format("%" + 6 + "s", reword.getPrize()))
                .collect(Collectors.joining()));
    }

    public void drawGameRecords(Name targetName, GameRecords gameRecords) {
        if (targetName.equals(new Name("all"))) {
            drawGameRecords(gameRecords.getRewardGamers());
        }
        drawGameRecords(List.of(gameRecords.find(targetName)));
    }

    private void drawGameRecords(List<RewardResult> rewardResults) {
        System.out.println("실행 결과");
        rewardResults.forEach(e -> System.out.println(
                String.format("%s : %s", e.getName(), e.getPrize())
        ));
    }
}
