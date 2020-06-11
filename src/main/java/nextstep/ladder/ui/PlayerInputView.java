package nextstep.ladder.ui;

import nextstep.ladder.domain.player.Players;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlayerInputView {
    private static final String INPUT_PLAYERS_COMMENT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String NAME_SEPARATOR = ",";

    private Players players;

    public PlayerInputView(String playerNameValues) {
        validate(playerNameValues);
        this.players = Players.create(parseToNames(playerNameValues));
    }

    public static PlayerInputView createByUserInput(Scanner scanner) {
        return new PlayerInputView(getUserInputPlayers(scanner));
    }

    public Players getPlayers() {
        return players;
    }

    public int getPlayerSize() {
        return this.players.size();
    }

    public void validate(String playerNameValues) {
        validateNull(playerNameValues);
        validateEmpty(playerNameValues);
    }

    private void validateNull(String playerNameValues) {
        if (playerNameValues == null) {
            throw new IllegalArgumentException("Input value must not be null");
        }
    }

    private void validateEmpty(String playerNameValues) {
        if (playerNameValues.trim().isEmpty()) {
            throw new IllegalArgumentException("Input value must not be empty");
        }
    }

    private static String getUserInputPlayers(Scanner scanner) {
        System.out.println(INPUT_PLAYERS_COMMENT);
        return scanner.nextLine();
    }

    private List<String> parseToNames(String inputValue) {
        return Arrays.stream(inputValue.split(NAME_SEPARATOR))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
