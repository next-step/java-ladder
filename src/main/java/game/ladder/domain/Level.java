package game.ladder.domain;

import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.Comparator;

public enum Level {

    HIGH("상", 20), MIDDLE("중", 30), LOW("하", 50);

    public static final int MAXIMUM_RATE = 100;
    public static final int MINIMUM_RATE = 1;

    private final String name;
    private final int rate;

    Level(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }

    public static Level getLevel(int number) {

        Preconditions.checkArgument(number >= MINIMUM_RATE && number <= MAXIMUM_RATE, "범위를 벗어난 숫자입니다.");

        return Arrays.stream(values()).sorted(Comparator.comparingInt(l -> l.rate))
                .filter(level -> level.isRange(number)).findFirst().orElse(Level.LOW);
    }

    public String getName() {
        return this.name;
    }

    private boolean isRange(int number) {
        return number >= getRate();
    }

    private int getRate() {
        return MAXIMUM_RATE - rate;
    }

}
