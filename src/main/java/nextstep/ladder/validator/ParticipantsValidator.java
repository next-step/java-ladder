package nextstep.ladder.validator;

import nextstep.ladder.domain.Participant;
import nextstep.ladder.exception.NotInParticipantsException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static nextstep.ladder.domain.Participants.meanAllParticipants;

public class ParticipantsValidator {

    public static boolean notMatchParticipantsSize(List<String> compare, int numberOfParticipant) {
        return compare.size() != numberOfParticipant;
    }

    public static void validateInParticipants(Set<Participant> participants, String name) {
        if (notInParticipants(participants, name)) {
            throw new NotInParticipantsException(participants, name);
        }
    }

    public static boolean notInParticipants(Set<Participant> participants, String name) {
        return !containsParticipantNames(participants, name) && !meanAllParticipants(name);
    }

    private static boolean containsParticipantNames(Set<Participant> participants, String name) {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toUnmodifiableSet())
                .contains(name);
    }

}
