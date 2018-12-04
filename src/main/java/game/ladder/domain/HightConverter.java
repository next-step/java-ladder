package game.ladder.domain;

import java.util.EnumMap;
import java.util.Map;

public class HightConverter {

    private static final Map<Level, Height> LEVEL_HEIGHT_MAP = new EnumMap<>(Level.class);

    static {
        LEVEL_HEIGHT_MAP.put(Level.HIGH, new Height(20));
        LEVEL_HEIGHT_MAP.put(Level.MIDDLE, new Height(10));
        LEVEL_HEIGHT_MAP.put(Level.LOW, new Height(5));
    }

    public static Height convert(Level level) {
        return LEVEL_HEIGHT_MAP.get(level);
    }

}
