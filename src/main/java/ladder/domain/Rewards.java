package ladder.domain;

import ladder.exception.result.ResultNotExistException;

import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rewards {

    public final List<LadderTextInput> results;

    public Rewards(String... strings) {
        this.results = Stream.of(strings)
                .map(LadderTextInput::new)
                .collect(Collectors.toList());
    }

    public List<LadderTextInput> rewards() {
        return Collections.unmodifiableList(results);
    }

    public LadderTextInput reward(Point index) {
        if (results.size() < index.x) {
            throw new ResultNotExistException();
        }
        return results.get(index.x);
    }
}
