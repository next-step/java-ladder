package nextstep.ladder.domain;

import java.util.Objects;

public class Rung {
    private final boolean isExist;

    public Rung(boolean isExist) {
        this.isExist = isExist;
    }

    public boolean isExist() {
        return this.isExist;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Rung rung = (Rung) object;
        return isExist == rung.isExist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isExist);
    }
}
