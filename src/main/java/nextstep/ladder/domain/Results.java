package nextstep.ladder.domain;

import java.util.Map;
import java.util.function.BiConsumer;

public class Results {
    public static final String ALL_KEYWORD = "all";
    private final Map<Name, String> value;

    private Results(Map<Name, String> value) {
        this.value = value;
    }

    public static Results of(Map<Name, String> value) {
        return new Results(value);
    }

    public boolean isAllKeyword(Name name) {
        return ALL_KEYWORD.equals(name.getValue());
    }

    public void forEach(BiConsumer<Name, String> biConsumer) {
        value.forEach(biConsumer);
    }

    public void accept(Name nameOfWantToCheck, BiConsumer<Name, String> biConsumer) {
        biConsumer.accept(nameOfWantToCheck, value.get(nameOfWantToCheck));
    }
}
