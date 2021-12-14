package nextstep.ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private static final String MESSAGE_CANT_PLAY_THE_GAME_ALONE = "혼자서는 사다리게임을 할 수 없습니다.";
    private static final int PLAYERS_MIN_SIZE = 1;

    private final List<Player> players;

    public Person(String[] splitNames) {
        this.players = convertToPlayers(splitNames);
    }

    private List<Player> convertToPlayers(String[] splitNames) {
        return Arrays.stream(validationSize(splitNames))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private String[] validationSize(String[] splitNames) {
        if (splitNames.length == PLAYERS_MIN_SIZE) {
            throw new IllegalArgumentException(MESSAGE_CANT_PLAY_THE_GAME_ALONE);
        }
        return splitNames;
    }


    @Override
    public String toString() {
        return players.stream()
                .map(Player::getName)
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining(" "));
    }
}
