package ladder.service;

import ladder.domain.Participant;
import ladder.domain.Participants;
import ladder.domain.Result;
import ladder.domain.ShowResultType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputService {
    private static final String ALL_PARTICIPANTS = "all";

    public static List<Participant> parseParticipants(String input) {
        List<String> stringParticipants = Arrays.stream(input.replaceAll("\\s", "")
                .split(",")).collect(Collectors.toList());

        return stringParticipants.stream().map(name -> new Participant(name, stringParticipants.indexOf(name))).collect(Collectors.toList());
    }

    public static List<Result> parseResults(String input) {
        return Arrays.stream(input.replaceAll("\\s", "")
                .split(",")).map(Result::new).collect(Collectors.toList());
    }

    public static ShowResultType getResultType(String input) {
        return ShowResultType.get(input);
    }

    public static int validateLadderHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("높이는 1보다 작을 수 없습니다.");
        }

        return height;
    }

    public static void validateResults(int numberOfParticipant, int numberOfResult) {
        if (numberOfParticipant != numberOfResult) {
            throw new IllegalArgumentException("참가자 수와 결과 수가 일치하지 않습니다.");
        }
    }

    public static void validateGetResultInput(String input, Participants participants) {
        if (!input.equals(ALL_PARTICIPANTS) && !participants.isParticipant(input)) {
            throw new IllegalArgumentException("참가자가 아닙니다.");
        }
    }
}
