package ladder.view;

import ladder.domain.Bridge;
import ladder.domain.Ladder;
import ladder.domain.LadderGameData;
import ladder.domain.LadderResult;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    public static void printLadderResult(Ladder ladder, LadderGameData gameDate) {
        System.out.println("\n사다리 결과\n");

        printParticipantNames(gameDate.getParticipantNames());
        printLadder(ladder.getSteps());
        printOutcomes(gameDate.getOutcomes());

    }

    private static void printParticipantNames(String[] participantNames) {
        Arrays.stream(participantNames)
                .forEach(name -> System.out.print(name + "  "));
        System.out.println();
    }

    private static void printLadder(List<Bridge> ladder) {
        StringBuilder output = new StringBuilder();

        ladder.forEach(bridge -> {
            List<Boolean> connections = bridge.getConnections();
            output.append("    |");
            connections.forEach(isConnected -> {
                if (isConnected) {
                    output.append("-----|");
                    return;
                }
                output.append("     |");
            });
            output.append("\n");
        });

        System.out.println(output);
    }

    private static void printOutcomes(String[] outcomes) {
        StringBuilder output = new StringBuilder();

        for (String outcome : outcomes) {
            output.append(outcome).append("    ");
        }

        System.out.println(output);
    }

    public static void printOutcomeForParticipant(String outcomeForParticipant) {
        System.out.println("\n실행결과");

        System.out.println(outcomeForParticipant);
    }

}
