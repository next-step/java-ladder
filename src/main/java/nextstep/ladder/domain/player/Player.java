package nextstep.ladder.domain.player;

import nextstep.ladder.domain.ladder.Lane;

public class Player {

    private final PlayerName playerName;
    private final Lane lane;

    private Player(PlayerName playerName, Lane lane) {
        this.playerName = playerName;
        this.lane = lane;
    }

    public static Player of(String name, int index) {
        return new Player(new PlayerName(name), Lane.wrap(index));
    }

    public boolean hasName(String targetName) {
        return playerName.equals(new PlayerName(targetName));
    }

    public Lane getLane() {
        return lane;
    }

    public String exportName() {
        return playerName.export();
    }


}
