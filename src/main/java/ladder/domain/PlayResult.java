package ladder.domain;

import java.util.Objects;

public class PlayResult {
    private final String playResult;

    public PlayResult(final String playResult) {
        validateNullOrEmpty(playResult);
        this.playResult = playResult;
    }

    private void validateNullOrEmpty(final String playResult) {
        if (Objects.isNull(playResult) || playResult.isEmpty()) {
            throw new IllegalArgumentException("실행 결과는 null 또는 empty 일 수 없습니다.");
        }
    }

    public String getValue() {
        return playResult;
    }

    @Override
    public String toString() {
        return String.valueOf(playResult);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PlayResult that = (PlayResult) o;
        return Objects.equals(playResult, that.playResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playResult);
    }
}
