package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.participant.Participants;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String EXECUTE_RESULT = "\n실행결과\n";
    private static final String WHITE_SPACE = " ";

    private static final String EXIST_LINE = "-----";
    private static final String NOT_EXIST_LINE = "     ";

    private static final String START_LINE = "    ";
    private static final String POINT = "|";

    private static final char SEPARATE_NAME_EXPRESSION = ' ';


    public static void outputLadder(Participants participants, Ladder ladder) {
        System.out.println(EXECUTE_RESULT);
        System.out.println(String.join(WHITE_SPACE, parseNames(participants.getParticipantNames())));

        for (int i = 0; i < ladder.sizeHeight(); i++) {
            System.out.print(START_LINE);

            outputLine(ladder.getLine(i));

            System.out.print(POINT + "\n");
        }
    }

    private static void outputLine(List<Boolean> lines) {
        for(boolean line : lines){
            System.out.print(POINT);
            System.out.print(line == true ? EXIST_LINE : NOT_EXIST_LINE);
        }
    }

    private static List<String> parseNames(List<String> participantNames) {
        List<String> names = participantNames.stream()
                .map(name -> String.format("%-5s", name).replace(SEPARATE_NAME_EXPRESSION, SEPARATE_NAME_EXPRESSION))
                .collect(Collectors.toList());

        parseLastName(names);
        return names;
    }

    private static void parseLastName(List<String> names) {
        int lastIndex = names.size() - 1;
        String lastName = names.get(lastIndex).trim();

        lastName = String.format("%4s", lastName).replace(SEPARATE_NAME_EXPRESSION, SEPARATE_NAME_EXPRESSION);
        names.set(lastIndex, lastName);
    }
}

