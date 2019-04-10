package domain;

import org.apache.commons.lang3.StringUtils;

public class Position {
    private static final Integer MIN_USER_NAME_LENGTH = 1;
    private static final Integer MAX_USER_NAME_LENGTH = 5;

    private String name;
    private Integer location;

    public Position(String name, Integer location) {
        if(name.length() < MIN_USER_NAME_LENGTH || name.length() > MAX_USER_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Integer getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return StringUtils.rightPad(name, MAX_USER_NAME_LENGTH + 1);
    }
}
