package ladder.domain;

import ladder.exception.LadderExceptionMessage;
import ladder.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Participants {
    private static final String DELIMITER = ",";
    private static final int PARTICIPANTS_MIN_COUNT = 1;

    private List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Name> getNames() {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    public static Participants from(String input) {
        if (StringUtils.isEmpty(input)) {
            throw new IllegalArgumentException(LadderExceptionMessage.PARTICIPANT_NEED_MORE_THAN_ONE);
        }

        List<Participant> participant = splitBy(input);

        return new Participants(participant);
    }

    private static List<Participant> splitBy(String input) {
        List<Participant> participants = new ArrayList<>();
        List<String> names = Arrays.asList(StringUtils.split(input, DELIMITER));

        for (int index = 0; index < names.size(); index++) {
            String name = names.get(index);
            Participant participant = Participant.of(name, index);
            participants.add(participant);
        }

        return participants;
    }

    public int getNumber() {
        return participants.size();
    }

    boolean isShortage() {
        return participants.size() <= PARTICIPANTS_MIN_COUNT;
    }

    public LadderGameResult calculateResult(Ladder ladder, LadderReward ladderReward) {
        return participants
                .stream()
                .collect(collectingAndThen(toMap(Participant::getName
                        , participant -> participant.calculateResult(ladder))
                        , resultByName -> LadderGameResult.of(resultByName, ladderReward)));
    }

}
