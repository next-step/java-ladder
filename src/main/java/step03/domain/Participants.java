package step03.domain;

import exception.DuplicatedParticipantsNameException;
import exception.InvalidCountOfParticipantsException;
import step03.utils.Tokenizer;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {
    private static final Integer MIN_COUNT_OF_PARTICIPANTS = 2;
    private final List<Name> participants;


    private Participants(List<Name> participants) {
        this.participants = participants;
    }

    public static Participants of(String names) {
        return new Participants(parseNames(names));
    }

    private static List<String> tokenizeNames(String names) {
        return Tokenizer.tokenizeWithComma(names);
    }

    private static void validate(List<String> nameTokens) {
        if (isDuplicated(nameTokens)) {
            throw new DuplicatedParticipantsNameException();
        }

        if (isInValidCountOfParticipant(nameTokens)) {
            throw new InvalidCountOfParticipantsException();
        }
    }

    private static boolean isDuplicated(List<String> nameTokens) {
        return nameTokens.stream().distinct().count() != nameTokens.size();
    }

    private static boolean isInValidCountOfParticipant(List<String> nameTokens) {
        return nameTokens.size() < MIN_COUNT_OF_PARTICIPANTS;
    }

    private static List<Name> parseNames(String names) {
        List<String> nameTokens = tokenizeNames(names);
        validate(nameTokens);

        return nameTokens.stream()
                .map(Name::of)
                .collect(Collectors.toList());
    }

    public Integer size() {
        return participants.size();
    }

    public List<String> getNames() {
        return participants.stream()
                .map(Name::toString)
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
