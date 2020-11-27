package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameSplitter {

    private NameSplitter() {}

    public static List<Player> splitParticipationNames(String participationNames) {
        return Arrays.stream(splitName(participationNames))
                .map(Player::of)
                .collect(Collectors.toList());
    }

    private static String[] splitName(String participationNames) {
        return participationNames.split(",");
    }
}
