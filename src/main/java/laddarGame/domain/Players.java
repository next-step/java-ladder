package laddarGame.domain;

import laddarGame.dto.PlayerDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private final List<Player> playerList;

    private static final String DELIMITER = ",";
    private static final int ZERO = 0;

    public Players(String playerNames) {
        this(playerList(nameParser(playerNames)));
    }

    public Players(List<Player> playerList) {
        isDuplicatePosition(playerList);
        this.playerList = playerList;
    }

    private static List<Player> playerList(String[] playerNames) {
        return IntStream.range(ZERO, playerNames.length)
                .mapToObj(posiotion -> new Player(playerNames[posiotion], posiotion))
                .collect(Collectors.toList());
    }

    private static String[] nameParser(String playerNames) {
        return playerNames.split(DELIMITER);
    }

    public int playerCount() {
        return playerList.size();
    }

    public int distinctCount(List<Player> players) {
        return (int) players.stream()
                .map(Player::getPosition)
                .distinct()
                .count();
    }

    public void isDuplicatePosition(List<Player> playerList) {
        int distinctCount = distinctCount(playerList);
        if (distinctCount != playerList.size()) {
            throw new IllegalArgumentException("같은 포지션에 두명이 있을 수 없습니다.");
        }
    }

    public List<PlayerDto> playersDto() {
        return playerList.stream()
                .map(Player::playerDto)
                .collect(Collectors.toList());
    }
}
