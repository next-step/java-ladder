package ladder.step2.domain;

import java.util.Objects;

public class PartLine {
    private final boolean partLine;
    
    public PartLine(boolean partLine) {
        this.partLine = partLine;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartLine partLine1 = (PartLine) o;
        return partLine == partLine1.partLine;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(partLine);
    }
    
    @Override
    public String toString() {
        if (partLine) {
            return "--------|";
        }
        
        return "        |";
    }
}
