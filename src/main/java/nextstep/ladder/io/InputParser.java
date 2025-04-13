package nextstep.ladder.io;

import nextstep.ladder.dto.Participant;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputParser {
    private static final String DELIMITER = ",";

    private InputParser() {
    }

    public static List<Participant> parseParticipants(String inputNames) {
        String[] names = inputNames.split(DELIMITER);

        return Stream.of(names)
                .map(String::trim)
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public static List<String> parseResults(String inputResults) {
        String[] results = inputResults.split(DELIMITER);

        return Stream.of(results)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
