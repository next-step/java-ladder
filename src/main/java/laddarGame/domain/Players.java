package laddarGame.domain;

import laddarGame.dto.PlayerDto;
import laddarGame.exception.DuplicatePositionException;
import laddarGame.util.Parser;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Players {

    private List<Player> playerList;

    private static final int ZERO = 0;

    public Players(String playerNames) {
        this(playerList(Parser.nameParser(playerNames)));
    }

    public Players(List<Player> playerList) {
        isDuplicatePosition(playerList);
        this.playerList = playerList;
    }

    private static List<Player> playerList(String[] playerNames) {
        return IntStream.range(ZERO, playerNames.length)
                .mapToObj(position -> new Player(playerNames[position], position))
                .collect(toList());
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
            throw new DuplicatePositionException("같은 포지션에 두명이 있을 수 없습니다.");
        }
    }

    public List<PlayerDto> playersDto() {
        return playerList.stream()
                .map(Player::playerDto)
                .collect(toList());
    }

    public Player getPlayer(int index) {
        return playerList.get(index);
    }

    public void movePoint(List<Point> line) {
        IntStream.range(0, line.size() - 1)
                .forEach(index -> line.get(index).move(getPlayer(index), getPlayer(index + 1)));
        sorted();
    }

    private void sorted() {
        this.playerList = playerList.stream()
                .sorted(Player::compare)
                .collect(toList());
    }
}
