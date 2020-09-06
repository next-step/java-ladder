package nextstep.dto;

import nextstep.entity.Ladder;

import java.util.List;

public class LadderDTO {

    private final Ladder ladder;

    public LadderDTO(Ladder ladder) {
        this.ladder = ladder;
    }

    public List<String> getEntryNames() {
        return this.ladder.getEntryNames();
    }

    public List<List<Boolean>> getResult() {
        return this.ladder.getResult();
    }
}
