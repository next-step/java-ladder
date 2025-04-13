package nextstep.ladder.domain;

import nextstep.ladder.domain.edge.LadderPrizes;
import nextstep.ladder.domain.edge.LadderUsers;
import nextstep.ladder.domain.line.Height;
import nextstep.ladder.domain.line.LineFactory;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.dto.LadderDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final Lines lines;
    private final LadderUsers users;
    private final LadderPrizes prizes;

    public Ladder(LadderUsers users, LadderPrizes prizes, int height) {
        this(users, prizes, new Height(height), new LineFactory());
    }

    public Ladder(LadderUsers users, LadderPrizes prizes, Height height, LineFactory lineFactory) {
        this.users = users;
        this.prizes = prizes;
        this.lines = new Lines(users.size(), height, lineFactory);
    }

    public LadderDto toLadderDto() {
        List<String> names = users.getNames();
        List<List<Boolean>> ladder = lines.getvalue();
        List<String> prizes = this.prizes.getLadderPrizes();

        LadderUsers moved = lines.moveUsers(users);
        List<String> movedNames = moved.getNames();
        List<String> prizeResults = moved.result(this.prizes).getLadderPrizes();

        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < moved.size(); i++) {
            result.put(movedNames.get(i), prizeResults.get(i));
        }

        return new LadderDto(names, ladder, prizes, result);
    }
}
