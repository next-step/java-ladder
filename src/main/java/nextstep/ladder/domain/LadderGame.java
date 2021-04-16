package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final List<Player> playerList;
    private Ladder ladder;

    public LadderGame(List<String> names, int height) {
        this(names);
        ladder = new Ladder(height, names.size());
    }

    public LadderGame(List<String> names, Ladder ladder) {
        this(names);
        this.ladder = ladder;
    }

    private LadderGame(List<String> names) {
        playerList = new ArrayList<>(names.size());
        for (int i = 0; i < names.size(); i++) {
            playerList.add(new Player(names.get(i), new Point(i)));
        }
    }

    public List<String> build() {
        return ladder.build();
    }

    public List<String> getAllPlayerNames() {
        return playerList.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int getPlayerCount() {
        return playerList.size();
    }

    public void start() {
        for (int i = 0; i < getPlayerCount(); i++) {
            playerList.set(i, ladder.rideLadder(playerList.get(i)));
        }
    }

    public Player findPlayerByName(String name) {
        return playerList.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름을 가진 플레이어가 없습니다."));
    }
}
