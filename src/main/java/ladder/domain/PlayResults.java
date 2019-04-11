package ladder.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@EqualsAndHashCode
@ToString
public class PlayResults {
    private List<PlayResult> playResults = new ArrayList<>();

    public PlayResults(List<PlayResult> playerResults) {
        this.playResults.addAll(playerResults);
    }

    public PlayResult findResultByName(String userName) {
        Optional<PlayResult> playResult = playResults.stream()
                .filter(playerResult -> playerResult.isEqualsName(userName))
                .findFirst();
        return playResult.orElseThrow(() -> new IllegalArgumentException("없는유저에욤"));
    }
}