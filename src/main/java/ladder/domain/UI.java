package ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum UI {
    HORIZONTAL("-----", true),
    EMPTY("     ", false),
    VERTICAL("|", true);

    private String stringUi;
    private boolean drawable;

    private UI(String stringUi, boolean drawable) {
        this.stringUi = stringUi;
        this.drawable = drawable;
    }

    private static Map<Draw, UI> STRINGS = Collections
                                        .unmodifiableMap(Stream.of(values())
                                        .filter(i -> !i.toString().equals("VERTICAL"))
                                        .collect(Collectors.toMap(ui -> Draw.of(ui.getDrawableStatus()), Function.identity())));

    public static UI find(Draw draw) {
        return Optional.ofNullable(STRINGS.get(draw)).orElse(VERTICAL);
    }

    public static UI find() {
        return VERTICAL;
    }

    public String getString() {
        return stringUi;
    }

    private boolean getDrawableStatus() {
        return drawable;
    }

}
