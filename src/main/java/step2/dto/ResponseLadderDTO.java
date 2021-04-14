package step2.dto;

public class ResponseLadderDTO {
    private final boolean hasLine;

    public ResponseLadderDTO(boolean hasLine) {
        this.hasLine = hasLine;
    }

    public boolean hasLine() {
        return hasLine;
    }
}
