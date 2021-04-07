package nextstep.ladder.domain.player;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.dto.PlayerDto;

public class Player {

    private final Name name;
    private final int position;

    public Player(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public boolean hasName(Name targetName) {
        return name.equals(targetName);
    }

    public PlayerDto export() {
        return new PlayerDto(name.export());
    }

    public int passThrough(Ladder ladder) {
        return ladder.passThrough(position);
    }

}
