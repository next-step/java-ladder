package nextstep.ladder.domain;

import java.util.Map;
import java.util.function.BiConsumer;

public class Results {
    private static final String ALL = "all";
    private final Map<String, String> value;

    private Results(Map<String, String> value) {
        this.value = value;
    }

    public static Results of(Map<String, String> value) {
        return new Results(value);
    }

    public boolean isAll(String name) {
        return ALL.equals(name);
    }

    public void forEach(BiConsumer<String, String> biConsumer) {
        value.forEach(biConsumer);
    }

    public void accept(String nameOfWantToCheck, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(nameOfWantToCheck, value.get(nameOfWantToCheck));
    }
}
