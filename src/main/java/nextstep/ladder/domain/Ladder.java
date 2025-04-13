package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Height;
import nextstep.ladder.domain.line.LineFactory;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.user.LadderUsers;
import nextstep.ladder.dto.LadderDto;

import java.util.List;

public class Ladder {
    private final LadderUsers ladderUsers;
    private final Lines lines;


    public Ladder(List<String> names, int height) {
        this(names, height, new LineFactory());
    }

    public Ladder(List<String> names, int height, LineFactory lineFactory) {
        this.ladderUsers = new LadderUsers(names);
        this.lines = new Lines(this.ladderUsers, new Height(height), lineFactory);
    }

    public LadderDto toLadderResult() {
        return new LadderDto(ladderUsers.getLadderUserNames(), lines.getvalue());
    }
}
