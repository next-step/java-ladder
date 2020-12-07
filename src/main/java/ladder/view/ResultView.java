package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.participant.Participants;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String EXECUTE_RESULT = "실행결과\n";
    private static final String WHITE_SPACE = " ";

    private static final String POINT = "-----";
    private static final String SPACE = "     ";

    private static final String START_LINE = "    ";

    public static void executeLadder(Participants participants, Ladder ladder) {
        System.out.println();
        System.out.println(EXECUTE_RESULT);

        System.out.println(String.join(WHITE_SPACE, parseNames(participants.getParticipantNames())));

        for (int i = 0; i < ladder.sizeHeight(); i++) {
            System.out.print(START_LINE);
            for (int j = 0; j < ladder.sizeWidth(); j++) {
                System.out.print("|");
                if (ladder.findByIndex(i).isAvailableMove(j)) {
                    System.out.print(POINT);
                } else {
                    System.out.print(SPACE);
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }

    private static List<String> parseNames(List<String> participantNames) {
        List<String> names = participantNames.stream()
                .map(name -> String.format("%-5s", name).replace(' ', ' '))
                .collect(Collectors.toList());

        parseLastName(names);
        return names;
    }

    private static void parseLastName(List<String> names) {
        int lastIndex = names.size() - 1;
        String lastName = names.get(lastIndex).trim();

        lastName = String.format("%4s", lastName).replace(' ',' ');
        names.set(lastIndex, lastName);
    }

}

