package domain;

import common.CommonConstants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PlayerNames {
    private final List<String> playerNames;

    private PlayerNames(List<String> playerNames) {
        this.playerNames = playerNames;
    }

    public static PlayerNames of(final String names) {
        return new PlayerNames(Arrays.asList(names.split(CommonConstants.SPLIT_DELIMITER_COMMA)));
    }

    public int size() {
        return playerNames.size();
    }

    public Stream<String> stream() {
        return playerNames.stream();
    }
}
