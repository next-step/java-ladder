package nextstep.ladder.domain;

public class Name {

    private final String name;

    public Name(String name) {
        hasNullOrEmpty(name);
        this.name = name;
    }

    private void hasNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
    }
}
