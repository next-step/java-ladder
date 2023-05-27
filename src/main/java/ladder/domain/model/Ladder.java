package ladder.domain.model;

import java.util.stream.IntStream;

public class Ladder {
    private Players players;
    private Lines lines;

    public Ladder(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    public void playGame() {
        IntStream.range(0, players.getPlayerCount())
                .forEach(index -> lines.move(players.getPlayers().get(index)));
    }
    // 사다리 타기 게임의 특징
    // 왼쪽, 오른쪽 확인 후 트루인지 확인

}
