package ladder.domain;

import java.util.Objects;

public class Path {

    private int startIndex;
    private int endIndex;

    private Path(int startIndex, int endIndex){
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public static Path of(int startIndex, int endIndex){
        return new Path(startIndex, endIndex);
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex(){
        return endIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Path path = (Path) o;
        return startIndex == path.startIndex &&
                endIndex == path.endIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startIndex, endIndex);
    }
}
