package refactoring.domain;

import java.util.List;

public interface Ladder {

    Match match(Results results, Match matchResult);
    List<Line> get();
}
