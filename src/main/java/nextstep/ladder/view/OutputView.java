package nextstep.ladder.view;

import nextstep.ladder.domain.ExecuteResult;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.NextStepLines;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;

import java.util.HashMap;
import java.util.Map;

public class OutputView {

    public static final Map<Boolean, String> POINTS_LINE = new HashMap<>();

    static {
        POINTS_LINE.put(true, outputLineTrue());
        POINTS_LINE.put(false, outputLineFalse());
    }

    public void outputResult(ExecuteResult executeResult, NextStepLines nextStepLines, LadderResult ladderResult) {
        System.out.println();

        outputLadder(nextStepLines);

        ouputExecuteResult(executeResult);
    }

    private static void outputLadder(NextStepLines nextStepLines) {
        nextStepLines.getLines().forEach(line -> {
            line.getPoints().forEach(points -> System.out.print(POINTS_LINE.get(points)));
            System.out.println("|");
        });
    }

    public void outputParticipants(Participants participants) {
        participants.getParticipants().forEach(participant -> System.out.print(participant.toString() + " "));
    }

    public static String outputLineTrue() {
        StringBuilder outputLine = new StringBuilder("|");
        for (int i = 0; i < Participant.MAX_NAME_LENGTH; i++) {
            outputLine.append("-");
        }
        return outputLine.toString();
    }

    public static String outputLineFalse() {
        StringBuilder outputLine = new StringBuilder("|");
        for (int i = 0; i < Participant.MAX_NAME_LENGTH; i++) {
            outputLine.append(" ");
        }
        return outputLine.toString();
    }

    public void ouputExecuteResult(ExecuteResult executeResult) {
        executeResult.getResults().forEach(resultStr -> System.out.print(String.format("%-5s", resultStr) + " "));
        System.out.println();
    }

    public void outputParticipantResult(String partition) {
        System.out.println(partition);
    }

    public void outputParticipantAllResult(LadderResult ladderResult) {
        System.out.println("전체결과");
        ladderResult.getPlayerToReward().forEach(
                (participant, result) -> System.out.println(participant.getName() + ":" + result)
        );
    }
}
