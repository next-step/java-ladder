package nextstep.ladder.domain;

import java.util.Objects;

public class LadderName {
    private String laddername;

    public LadderName(String ladderName) {
        this.laddername = ladderName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderName that = (LadderName) o;
        return Objects.equals(laddername, that.laddername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(laddername);
    }

    @Override
    public String toString() {
        return laddername;
    }
}
