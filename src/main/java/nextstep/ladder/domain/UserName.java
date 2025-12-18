package nextstep.ladder.domain;

import java.util.Objects;

public class UserName {

    private final String name;

    public UserName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("참여자 이름은 최대 5글자까지 입력 가능합니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(getName(), userName.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
