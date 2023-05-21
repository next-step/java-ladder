package nextstep.ladder.dto;

import nextstep.ladder.domain.Gamers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GamersDto {
    private final List<GamerDto> gamers;

    private GamersDto(List<GamerDto> gamers) {
        this.gamers = Collections.unmodifiableList(gamers);
    }

    public static GamersDto from(Gamers gamers) {
        return gamers.getGamers().stream()
                .map(GamerDto::from)
                .collect(Collectors.collectingAndThen(Collectors.toUnmodifiableList(), GamersDto::new));
    }

    public List<GamerDto> getGamers() {
        return gamers;
    }
}
