package step02.domain;

import exception.DuplicatedNameException;
import exception.InvalidCountOfNamesException;

import java.util.Arrays;
import java.util.Collections;
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
        if (isDuplicated(nameTokens)) {
            throw new DuplicatedNameException();
        }

        if (isInValidCountOfParticipant(nameTokens)) {
            throw new InvalidCountOfNamesException();
        }
    }

    private static boolean isDuplicated(String[] nameTokens) {
        return Arrays.stream(nameTokens).distinct().count() != nameTokens.length;
    }

    private static boolean isInValidCountOfParticipant(String[] nameTokens) {
        return nameTokens.length < MIN_COUNT_OF_PARTICIPANTS;
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

    public List<String> getNames() {
        return participants.stream()
                .map(Participant::toString)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
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
