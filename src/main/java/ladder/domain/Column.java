package ladder.domain;

import java.util.Objects;

public class Column {
    private final boolean marked;

    private Column(boolean marked) {
        this.marked = marked;
    }

    public static Column of(boolean marked){
        return ColumnCache.of(marked);
    }

    public boolean isMarked() {
        return marked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return marked == column.marked;
    }

    @Override
    public int hashCode() {
        return Objects.hash(marked);
    }

    static class ColumnCache{
        private static final Column TRUE = new Column(true);
        private static final Column FALSE = new Column(false);

        static Column of(boolean marked){
            if(marked){
                return TRUE;
            }
            return FALSE;
        }
    }

    @Override
    public String toString() {
        if(this.isMarked()){
            return "-----";
        }
        return "     ";
    }
}
