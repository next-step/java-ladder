package nextstep.mission.domain;

import nextstep.mission.lib.StringUtils;

import java.util.Objects;

public class Participant {

    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("사용자 이름값은 null 이거나 빈 문자를 허용하지 않습니다.");
        }

        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("사용자 이름 길이는 5를 초과할 수 없습니다.");
        }

        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
