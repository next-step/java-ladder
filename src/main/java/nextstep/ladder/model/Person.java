package nextstep.ladder.model;

import nextstep.ladder.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private static final String DELIMITER = ",";
    private static final String MESSAGE_CANT_PLAY_THE_GAME_ALONE = "혼자서는 사다리게임을 할 수 없습니다.";
    private static final int PLAYERS_MIN_SIZE = 1;

    private final List<Player> players;

    public Person(String inputNames) {
        this.players = convertTo(StringUtils.isNullOrEmpty(inputNames));
    }

    private List<Player> convertTo(String inputNames) {
        String[] splitNames = validationSplit(inputNames);
        return Arrays.stream(splitNames)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private String[] validationSplit(String inputNames) {
        String[] names = inputNames.split(DELIMITER);
        if (names.length == PLAYERS_MIN_SIZE) {
            throw new IllegalArgumentException(MESSAGE_CANT_PLAY_THE_GAME_ALONE);
        }
        return names;
    }


    @Override
    public String toString() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(", "));
    }
}
