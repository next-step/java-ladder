package ladder;

import java.util.Objects;

public class PlayerName {
    public static final int MAXIMUM_NAME_LENGTH = 5;
    private String name;

    public PlayerName(String name) {
        this.name = nameComplianceCheck(name);
    }

    private String nameComplianceCheck(String name) {
        if (name.trim().length() > MAXIMUM_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 1~5글자 사이입니다.");
        }
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName name1 = (PlayerName) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
