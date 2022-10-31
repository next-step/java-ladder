package ladder.domain.result;

import ladder.domain.LadderTextInput;
import ladder.exception.result.ResultNotExistException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Results {

    public final List<LadderTextInput> results;

    public Results(String... strings) {
        this.results = Stream.of(strings)
                .map(LadderTextInput::new)
                .collect(Collectors.toList());
    }

    public List<LadderTextInput> results() {
        return Collections.unmodifiableList(results);
    }

    public LadderTextInput result(int index) {
        if (results.size() < index) {
            throw new ResultNotExistException();
        }
        return results.get(index);
    }
}
