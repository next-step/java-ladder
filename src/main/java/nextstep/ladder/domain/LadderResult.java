package nextstep.ladder.domain;

import java.util.Objects;

public class LadderResult {

    private final String name;
    private final int position;


    public LadderResult(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderResult)) return false;

        LadderResult that = (LadderResult) o;

        if (position != that.position) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + position;
        return result;
    }
}
