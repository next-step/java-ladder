package ladder.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Player {
    public static final int DEFAULT_LADDER_WIDTH = 5;
    public static final int FOR_MULTI_VALUE = 1;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    public int nameLength() {
        return (name.length() / DEFAULT_LADDER_WIDTH) + FOR_MULTI_VALUE;
    }

}
