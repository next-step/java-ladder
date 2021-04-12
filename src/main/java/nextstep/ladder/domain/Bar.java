package nextstep.ladder.domain;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Bar {

    private static final Bar BAR = Bar.valueOf(FALSE);
    public final boolean flag;

    private Bar(final boolean flag) {
        this.flag = flag;
    }

    public static Bar valueOf(final boolean flag) {
        return new Bar(flag);
    }

    public static Bar init() {
        return BAR;
    }

    public boolean isExist() {
        return flag;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Bar)) return false;
        final Bar bar = (Bar) o;
        return flag == bar.flag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flag);
    }

    @Override
    public String toString() {
        return String.valueOf(flag);
    }
}
