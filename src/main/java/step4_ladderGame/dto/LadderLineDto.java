package step4_ladderGame.dto;

import java.util.List;

public class LadderLineDto {

    private final List<Boolean> line;

    public LadderLineDto(List<Boolean> line) {
        this.line = line;
    }

    public List<Boolean> getLine() {
        return line;
    }
}
