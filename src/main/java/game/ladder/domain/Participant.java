package game.ladder.domain;

import spark.utils.Assert;
import spark.utils.StringUtils;

public class Participant {

    private final String name;
    private final Position position;

    public Participant(String name, Position position) {
        Assert.isTrue(StringUtils.isNotBlank(name), "name은 공백일 수 없습니다.");

        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participant that = (Participant) o;

        if (!name.equals(that.name)) return false;
        return position.equals(that.position);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + position.hashCode();
        return result;
    }
}
