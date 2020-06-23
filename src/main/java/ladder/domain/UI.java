package ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum UI {
    HORIZONTAL("-----"),
    EMPTY("     "),
    VERTICAL("|");

    private String stringUi;

    private UI(String stringUi) {
        this.stringUi = stringUi;
    }

    private static Map<String, UI> STRINGS = Collections
                                        .unmodifiableMap(Stream.of(values())
                                        .collect(Collectors.toMap(UI::toString, Function.identity())));

    public static UI find(String uiString) {
        return Optional.ofNullable(STRINGS.get(uiString)).orElse(VERTICAL);
    }

    public String getString() {
        return stringUi;
    }


}
