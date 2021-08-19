package ladder.domain.ladder;

import ladder.utils.StringUtil;

import java.util.Objects;

public class Award {

    private static final int LIMIT_LENGTH = 5;

    private final String name;

    public Award(String name) {
        if (StringUtil.isBlank(name)) {
            throw new AwardNameException();
        }
        if (name.trim().length() > LIMIT_LENGTH) {
            throw new AwardNameException();
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Award award = (Award) o;
        return Objects.equals(name, award.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
