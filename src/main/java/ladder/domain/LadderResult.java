package ladder.domain;

import java.util.Arrays;
import java.util.List;

public class LadderResult {
    private final String[] participantNames;
    private final String[] outcomes;

    public LadderResult(String[] participantNames, String[] outcomes) {
        this.participantNames = participantNames;
        this.outcomes = outcomes;
    }

    public void printParticipantNames() {
        Arrays.stream(participantNames)
                .forEach(name -> System.out.print(name + "  "));
        System.out.println();
    }

    public void printLadder(List<Bridge> ladders) {
        StringBuilder output = new StringBuilder();

        ladders.forEach(bridge -> {
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

    public void printOutcomes() {
        StringBuilder output = new StringBuilder();

        for (String outcome : outcomes) {
            output.append(outcome).append("    ");
        }

        System.out.println(output);
    }
}
