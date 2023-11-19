package nextstep.ladder.domain;

import java.util.Map;
import java.util.Objects;

public class LadderResult {
    private final PlayerResults playerResults;
    private final Lines lines;

    public LadderResult(PlayerResults playerResults,
                        Lines lines) {
        this.playerResults = playerResults;
        this.lines = lines;
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
        return Objects.equals(playerResults, that.playerResults) && Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerResults, lines);
    }

}
