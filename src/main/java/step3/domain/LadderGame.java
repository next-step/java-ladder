package step3.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderGame {
    private final Ladder ladder;
    private Position[] positions;

    public LadderGame(Ladder ladder, int countOfPlayers) {
        this.ladder = ladder;
        this.positions = new Position[countOfPlayers];
    }

    public PlayerResult getResult(Players players, Results results) {
        Map<String, String> playerResultMap = new HashMap<>();
        getPosition();

        for (int i = 0; i < positions.length; i++) {
            Player player = players.getPlayers().get(i);
            Result result = results.getResults().get(positions[i].position);
            playerResultMap.put(player.getName(), result.getResult());
        }

        return new PlayerResult(playerResultMap);
    }

    private Position[] getPosition() {
        initPosition();
        ladder.getLadder().forEach(line -> {
            IntStream.range(0, line.size())
                    .forEach(idx -> {
                        positions[idx].position = positions[idx].move(line.getPoints().get(positions[idx].position));
                    });
        });
        return positions;
    }

    private void initPosition() {
        Line firstLine = ladder.getLadder().stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사다리의 line 이 없습니다."));
        IntStream.range(0, firstLine.size())
                .forEach(idx -> {
                    positions[idx] = new Position(idx, firstLine.getPoints().get(idx));
                    positions[idx].position = positions[idx].move();
                });
        ladder.getLadder().remove(0);
    }
}
