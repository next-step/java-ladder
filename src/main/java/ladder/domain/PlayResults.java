package ladder.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class PlayResults {
    private List<PlayResult> playResults = new ArrayList<>();

    PlayResults(List<PlayResult> playerResults) {
        this.playResults.addAll(playerResults);
    }

    public PlayResult findResultByName(String userName) {
        Optional<PlayResult> test = playResults.stream()
                .filter(playerResult -> playerResult.isEqualsName(userName))
                .findFirst();
        return test.orElseThrow(() -> new IllegalArgumentException("없는유저에욤"));
    }
}