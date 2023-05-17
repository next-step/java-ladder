package nextstep.ladder.dto;

import java.util.Collections;
import java.util.List;

public class GamersDto {
    private final List<GamerDto> gamers;

    private GamersDto(List<GamerDto> gamers) {
        this.gamers = Collections.unmodifiableList(gamers);
    }

    public static GamersDto of(List<GamerDto> gamers) {
        return new GamersDto(gamers);
    }

    public List<GamerDto> getGamers() {
        return gamers;
    }
}
