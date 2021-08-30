package nextstep.ladder.domain.impl;

import nextstep.ladder.exception.NullParameterException;
import nextstep.ladder.exception.OutOfRangeException;
import nextstep.ladder.utils.StringUtils;

import java.util.Objects;

public class WinningPrize {

    private static final int MAX_LENGTH = 5;

    private final String prizeName;

    public WinningPrize(String prizeName) {
        validPlayerNameLength(prizeName);
        this.prizeName = prizeName;
    }

    private void validPlayerNameLength(String prizeName) {
        if (StringUtils.isBlank(prizeName)) {
            throw new NullParameterException(this);
        }
        if (prizeName.length() > MAX_LENGTH) {
            throw OutOfRangeException.shouldLessThan(prizeName.length(), MAX_LENGTH);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningPrize)) return false;
        WinningPrize that = (WinningPrize) o;
        return Objects.equals(prizeName, that.prizeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeName);
    }

    @Override
    public String toString() {
        return String.format("%5s", prizeName);
    }
}
