package step4.domain;

import java.util.Objects;

public class Ladder {

    private final Lines lines;

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public Lines getLines() {
        return lines;
    }

    public int getHeight() {
        return lines.getHeight();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ladder)) {
            return false;
        }

        Ladder ladder = (Ladder) o;

        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return lines != null ? lines.hashCode() : 0;
    }
}
