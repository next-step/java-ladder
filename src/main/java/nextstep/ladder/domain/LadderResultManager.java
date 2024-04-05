package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Map;

public class LadderResultManager {
    
    private final Map<Name, String> results;

    public LadderResultManager(final Names names, final Ladder ladder, final LadderResultDeterminer determiner) {
        this.results = names.toResult();
        update(ladder, determiner);
    }
    
    private void update(final Ladder ladder, final LadderResultDeterminer determiner) {
        results.forEach((name, result) -> {
            final int startColumn = determiner.getStartColumn(name);
            final int column = ladder.move(startColumn);
            results.put(name, determiner.getResultByIndex(column));
        });
    }

    public String getResultByName(final Name name) {
        return results.get(name);
    }

    public Map<Name, String> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
