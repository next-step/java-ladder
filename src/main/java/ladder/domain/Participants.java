package ladder.domain;

import ladder.exception.LadderExceptionMessage;
import ladder.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Participants {
    private static final String DELIMITER = ",";
    private static final int PARTICIPANTS_MIN_COUNT = 1;

    private List<Participant> participants;
    private static AtomicInteger participantsNumber = new AtomicInteger(0);

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Name> getNames() {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    public static Participants of(String input) {
        if (StringUtils.isEmpty(input)) {
            throw new IllegalArgumentException(LadderExceptionMessage.PARTICIPANT_NEED_MORE_THAN_ONE);
        }

        List<Participant> participant = splitBy(input);

        return new Participants(participant);
    }

    private static List<Participant> splitBy(String input) {
        return Stream.of(StringUtils.split(input, DELIMITER))
                .map(name -> Participant.of(name, participantsNumber.getAndAdd(1)))
                .collect(Collectors.toList());
    }

    public int getNumber() {
        return participants.size();
    }

    boolean isShortage() {
        return participants.size() <= PARTICIPANTS_MIN_COUNT;
    }

    public void calculateResult(Ladder ladder) {
        participants
                .forEach(participant -> participant.calculateResult(ladder));
    }

    public Map<Name, Integer> getResult() {
        return participants.stream()
                .collect(toMap(Participant::getName, Participant::getOrder));
    }

    public int getResultBy(String wishParticipant) {
        Name wishParticipantName = Name.from(wishParticipant);

        return Optional.ofNullable(getResult().get(wishParticipantName))
                .orElseThrow(() -> new IllegalArgumentException(LadderExceptionMessage.INVALID_PARTICIPANT));
    }
}
