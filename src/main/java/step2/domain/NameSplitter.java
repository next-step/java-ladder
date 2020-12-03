package step2.domain;

import step2.exception.EmptyNameException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameSplitter {

    private NameSplitter() { }

    public static List<String> splitParticipationNames(String participationNames) {
        validEmpty(participationNames);

        return Arrays.stream(splitName(participationNames))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static void validEmpty(String participationNames) {
        if (participationNames.trim().isEmpty()) {
            throw new EmptyNameException();
        }
    }

    private static String[] splitName(String participationNames) {
        return participationNames.split(",");
    }
}
