package step02.domain;

import exception.InvalidCountOfParticipantsException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {
    private static final String TOKEN = ",";
    private static final Integer MIN_COUNT_OF_PARTICIPANTS = 2;
    private final List<Participant> participants;


    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(String names) {
        return new Participants(parseNames(names));
    }

    private static String[] tokenizeNames(String names) {
        return names.split(TOKEN);
    }

    private static void validate(String[] nameTokens) {
        if (nameTokens.length < MIN_COUNT_OF_PARTICIPANTS) {
            throw new InvalidCountOfParticipantsException();
        }
    }

    private static List<Participant> parseNames(String names) {
        String[] nameTokens = tokenizeNames(names);
        validate(nameTokens);

        return Arrays.stream(nameTokens)
                .map(Participant::of)
                .collect(Collectors.toList());
    }

    public Integer size() {
        return participants.size();
    }

    public List<String> show() {
        return participants.stream()
                .map(participant -> participant.toString())
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return Objects.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants);
    }

}
