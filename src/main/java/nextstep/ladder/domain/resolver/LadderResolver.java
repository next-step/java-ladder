package nextstep.ladder.domain.resolver;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;

import java.util.ArrayList;
import java.util.List;

public class LadderResolver {

    private Ladder ladder;

    public LadderResolver(Ladder ladder) {
        this.ladder = ladder;
    }

    public int resultOf(int position) {
        int result = position;
        for(Line line: ladder.values()) {
            result = line.move(result);
        }

        return result;
    }

    public List<Integer> all() {
        List<Integer> results = new ArrayList<>();
        for(int i = 0; i < ladder.countOfPeople(); i++) {
            results.add(resultOf(i));
        }
        return results;
    }
}
