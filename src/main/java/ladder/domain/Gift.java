package ladder.domain;

import ladder.utils.StringUtils;

public class Gift {

    private String name;

    private Gift(String name) {
        this.name = name;
    }

    public static Gift create(String name) {
        return new Gift(name);
    }

    @Override
    public String toString() {
        return StringUtils.center(name);
    }
}
