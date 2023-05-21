package ladder.domain.model;

import java.util.stream.IntStream;

public class Ladder {
    private Players players;
    private Lines lines;
    private WinResults winResults;

    public Ladder(Players players, Lines lines, WinResults winResults) {
        this.players = players;
        this.lines = lines;
        this.winResults = winResults;
    }

    public void playGame() {
        IntStream.range(0, players.getPlayerCount())
                .forEach(index -> lines.getConnectNumber(players.getPlayers().get(index)));

        for (Player player : players.getPlayers()) {
            System.out.println(player.getResult());
        }
    }
    // 사다리 타기 게임의 특징
    // 왼쪽, 오른쪽 확인 후 트루인지 확인

}
