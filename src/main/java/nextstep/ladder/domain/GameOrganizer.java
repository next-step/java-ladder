package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOrganizer {

    private static final String DELIMITER = ",";

    private final List<Player> players;
    private final List<String> ladderResults;

    public GameOrganizer(List<Player> players, List<String> ladderResults) {
        this.players = players;
        this.ladderResults = ladderResults;
    }

    public static GameOrganizer of(String playerNames, String ladderResultNames) {
        List<String> players = toList(playerNames);
        List<String> ladderResults = toList(ladderResultNames);

        if (players.size() != ladderResults.size()) {
            throw new IllegalArgumentException("참가자 수와 사다리 결과 수가 일치하지 않습니다.");
        }

        return new GameOrganizer(players.stream().map(Player::new).collect(Collectors.toList()), ladderResults);
    }

    private static List<String> toList(String strings) {
        return Stream.of(Optional.ofNullable(strings)
                        .filter(string -> !string.isBlank())
                        .orElseThrow(() -> new IllegalArgumentException("문자열에 공백 또는 null은 허용되지 않습니다."))
                        .split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<String> playerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> ladderResults() {
        return Collections.unmodifiableList(ladderResults);
    }

    public MatchResult play(Ladder ladder) {
        List<Player> playerResults = new ArrayList<>(players);
        ladder.play(playerResults);
        return MatchResult.of(playerResults, ladderResults);
    }

    public int count() {
        return players.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameOrganizer that = (GameOrganizer) o;
        return Objects.equals(players, that.players) && Objects.equals(ladderResults, that.ladderResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, ladderResults);
    }
}
