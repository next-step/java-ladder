package ladder.view;

import ladder.domain.dto.Reward;
import ladder.domain.ladder.Ladder;
import ladder.domain.participant.Participants;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String EXECUTE_RESULT = "\n사다리 결과\n";
    private static final String WHITE_SPACE = " ";

    private static final String EXIST_LINE = "-----";
    private static final String NOT_EXIST_LINE = "     ";

    private static final String START_LINE = "    ";
    private static final String POINT = "|";

    private static final char SEPARATE_NAME_EXPRESSION = ' ';

    private static final String GAME_RESULT = "실행 결과";
    private static final String DELIMITER = " : ";


    public static void outputLadderGame(Participants participants, Ladder ladder, Reward reward) {
        System.out.println(EXECUTE_RESULT);

        outputParticipants(participants);
        outputLadder(ladder);
        outputReward(reward);
    }

    private static void outputParticipants(Participants participants) {
        System.out.println(String.join(WHITE_SPACE, parseNames(participants.getParticipantNames())));
    }

    private static void outputLadder(Ladder ladder) {
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

    private static void outputReward(Reward reward) {
        System.out.println(String.join(WHITE_SPACE, parseNames(reward.getReward())));
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

    public static void gameResult(String userRewardResult){
        System.out.println("\n"+GAME_RESULT);
        System.out.println(userRewardResult);
    }

    public static void gameAllResult(Map<String, String> result){
        System.out.println("\n"+GAME_RESULT);
        result.entrySet().stream()
                    .forEach(i -> System.out.println(i.getKey() + DELIMITER + i.getValue()));
    }
}

