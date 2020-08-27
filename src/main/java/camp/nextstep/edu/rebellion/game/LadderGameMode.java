package camp.nextstep.edu.rebellion.game;

import java.util.Arrays;

public enum LadderGameMode {
    ORIGIN(1, "ORIGIN"),
    CUSTOM(2, "CUSTOM");

    private final int id;
    private final String name;

    LadderGameMode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static LadderGameMode of(int id) {
        return Arrays.stream(values())
                .filter(e -> e.id == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 모드 입니다"));
    }
}
