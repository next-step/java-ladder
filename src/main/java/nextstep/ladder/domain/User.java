package nextstep.ladder.domain;

import java.util.Objects;
import java.util.Optional;

public class User {
    private static final int MAX_NAME_LENTH = 5;

    private final String name;
    private String result;

    public User(String name) {
        valdateName(name);
        this.name = name;
    }

    public void valdateName(String name) {
        Optional.ofNullable(name)
                .filter(n -> n.length() <= MAX_NAME_LENTH)
                .orElseThrow(() -> new IllegalArgumentException("이름은 최대 5자리만 입력 가능합니다."));

    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof User)) { return false; }
        final User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
