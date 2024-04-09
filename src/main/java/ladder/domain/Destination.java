package ladder.domain;

import java.util.Objects;

public class Destination {

    private final String result;

    public Destination(String result) {
        this.result = result;
    }

    public String result(){
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
