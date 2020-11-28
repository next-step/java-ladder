package nextstep.ladder.domain;

import java.util.Map;
import java.util.function.BiConsumer;

public class ExecutionResults {
    private final Map<Name, ResultCandidate> value;

    private ExecutionResults(Map<Name, ResultCandidate> value) {
        this.value = value;
    }

    public static ExecutionResults of(Map<Name, ResultCandidate> value) {
        return new ExecutionResults(value);
    }

    public void forEach(BiConsumer<Name, ResultCandidate> biConsumer) {
        value.forEach(biConsumer);
    }

    public void accept(Name nameOfWantToCheck, BiConsumer<Name, ResultCandidate> biConsumer) {
        biConsumer.accept(nameOfWantToCheck, value.get(nameOfWantToCheck));
    }
}
