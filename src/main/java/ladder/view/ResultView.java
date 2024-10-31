package ladder.view;

import ladder.domain.Bridge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printLadderResult(String[] participantNames, List<Bridge> ladder) {
        System.out.println("실행결과\n");

        printParticipantNames(participantNames);

        printLadder(ladder);
    }

    private static void printParticipantNames(String[] participantNames) {
        Arrays.stream(participantNames)
                .forEach(name -> System.out.print(name + "  "));
        System.out.println();
    }

    private static void printLadder(List<Bridge> ladders) {
        ladders.forEach(bridge -> {
            List<Boolean> connections = bridge.getConnections();
            StringBuilder output = new StringBuilder("    |");

            connections.forEach(isConnected -> {
                if (isConnected) {
                    output.append("-----|");
                    return;
                }
                output.append("     |");
            });

            System.out.println(output);
        });
    }

}
