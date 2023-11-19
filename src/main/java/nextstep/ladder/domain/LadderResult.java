package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LadderResult {
    private final PlayerResults playerResults;
    private final Ladder ladder;

    public LadderResult(PlayerResults playerResults,
                        Ladder ladder) {
        this.playerResults = playerResults;
        this.ladder = ladder;
    }

    public LadderResult(Map<Name, String> playerResults,
                        List<Line> ladder) {
        this(new PlayerResults(playerResults), new Ladder(ladder));
    }

    public Map<Name, String> results() {
        return this.playerResults.getAll();
    }

    public String result(String name) {
        return this.playerResults.findByName(new Name(name));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(playerResults, that.playerResults) && Objects.equals(ladder, that.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerResults, ladder);
    }

}
