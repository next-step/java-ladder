package ladder.domain;

import java.util.Objects;

public class Reword {
    private final String reword;

    public Reword(String reword) {
        this.reword = reword;
    }

    public String getReword() {
        return reword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reword reword1 = (Reword) o;
        return Objects.equals(reword, reword1.reword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reword);
    }
}
