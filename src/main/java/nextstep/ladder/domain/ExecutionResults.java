package nextstep.ladder.domain;

import java.util.Map;
import java.util.function.BiConsumer;

public class ExecutionResults {
    private final Map<Name, Result> value;

    private ExecutionResults(Map<Name, Result> value) {
        this.value = value;
    }

    public static ExecutionResults of(Map<Name, Result> value) {
        return new ExecutionResults(value);
    }

    public void forEach(BiConsumer<Name, Result> biConsumer) {
        value.forEach(biConsumer);
    }

    public void accept(Name nameOfWantToCheck, BiConsumer<Name, Result> biConsumer) {
        biConsumer.accept(nameOfWantToCheck, value.get(nameOfWantToCheck));
    }
}
