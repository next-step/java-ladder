package nextstep.ladder.domain;

import java.util.Objects;

public class LadderResult {

    private final String name;
    private final String result;


    public LadderResult(final String name, final String result) {
        this.name = name;
        this.result = result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderResult)) return false;

        LadderResult that = (LadderResult) o;

        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        int result1 = name != null ? name.hashCode() : 0;
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }
}
