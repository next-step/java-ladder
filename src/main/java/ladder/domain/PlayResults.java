package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayResults {
    private static final int MIN_COUNT = 2;

    private final List<PlayResult> playResults;

    public PlayResults(final String[] playResults) {
        this(Stream.of(playResults)
        .map(PlayResult::new)
        .collect(Collectors.toList()));
    }

    public PlayResults(final List<PlayResult> playResults) {
        validateSize(playResults);
        this.playResults = playResults;
    }

    private void validateSize(final List<PlayResult> playResults) {
        if (playResults.size() < MIN_COUNT) {
            throw new IllegalArgumentException("실행 결과는 최소 " + MIN_COUNT + "개 이상입니다.");
        }
    }

    public List<PlayResult> getPlayResults() {
        return playResults;
    }

    public PlayResult find(final Position position) {
        return playResults.get(position.getValue());
    }

    public boolean isSameLength(final int size) {
        return Objects.equals(playResults.size(), size);
    }
}
