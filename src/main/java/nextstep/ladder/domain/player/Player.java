package nextstep.ladder.domain.player;

import nextstep.ladder.dto.PlayerDto;

public class Player {

    private final Name name;

    public Player(String name) {
        this.name = new Name(name);
    }

    public boolean hasName(Name targetName) {
        return name.equals(targetName);
    }

    public PlayerDto export() {
        return new PlayerDto(name.export());
    }
}
