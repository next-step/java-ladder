package nextstep.ladder.util;

import nextstep.ladder.exception.PersonLengthException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParser {

    private StringParser() {
    }

    private static final String DEFAULT_PATTERN = ",";
    private static final int PERSON_MAX_LENGTH = 5;

    public static List<String> split(String text) {
        return Stream.of(text.split(DEFAULT_PATTERN))
                .map(StringParser::validatePersonNameSize)
                .collect(Collectors.toList());
    }

    private static String validatePersonNameSize(String person) {
        if (person.length() > PERSON_MAX_LENGTH) {
            throw new PersonLengthException(person);
        }
        return person;
    }

}
