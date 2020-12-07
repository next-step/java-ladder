package domain;

import common.CommonConstants;
import exception.InvalidPlayerNumberException;

import java.util.Arrays;
import java.util.List;

public class PlayerNames {
    private static final int PLAYERS_NUMBER_MIN = 2;
    private final List<String> playerNames;

    private PlayerNames(final List<String> playerNames) {
        this.playerNames = playerNames;
    }

    public static PlayerNames of(final String names) {
        List<String> playerNamesArray = Arrays.asList(names.split(CommonConstants.SPLIT_DELIMITER_COMMA));
        if(playerNamesArray.size() < PLAYERS_NUMBER_MIN) {
            throw new InvalidPlayerNumberException();
        }

        return new PlayerNames(playerNamesArray);
    }

    public int size() {
        return playerNames.size();
    }

    public List<String> unbox() {
        return playerNames;
    }

    public int indexOf(final String name) {
        return playerNames.indexOf(name);
    }

    public String get(final int index) {
        return playerNames.get(index);
    }
}
