package ladder.step2.domain;

public class PartLine {
    private final boolean partLine;
    
    public PartLine(final boolean partLine) {
        this.partLine = partLine;
    }
    
    public boolean isExist() {
        return partLine;
    }
    
    @Override
    public String toString() {
        return "PartLine{" +
                "partLine=" + partLine +
                '}';
    }
}
