package ladder.view;

import ladder.service.Bridge;
import ladder.service.Ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    public static void printLadderResult(String[] participantNames, Ladder ladder) {
        System.out.println("실행결과\n");

        printParticipantNames(participantNames);

        List<Bridge> ladders = ladder.getLadders();
        printLadder(ladders);
    }

    private static void printParticipantNames(String[] participantNames) {
        Arrays.stream(participantNames)
                .forEach(name -> System.out.print(name + "  "));
        System.out.println();
    }

    private static void printLadder(List<Bridge> ladders) {
        ladders.forEach(bridge -> {
            List<Boolean> connections = bridge.getConnections();
            String output = IntStream.range(0, connections.size())
                    .mapToObj(index -> {
                        if (index == connections.size() - 1) {
                            return connections.get(index) ? "|-----|" : "|     |";
                        }
                        return connections.get(index) ? "|-----" : "|     ";
                    })
                    .collect(Collectors.joining());
            System.out.println("    " + output);
        });
    }

}
