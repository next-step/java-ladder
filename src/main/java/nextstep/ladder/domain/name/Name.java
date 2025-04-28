package nextstep.ladder.domain.name;

public class Name {
    private String name;

    public Name(String name) {
        if (null == name || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("이름의 형식이 올바르지 않습니다. name=" + name);
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
