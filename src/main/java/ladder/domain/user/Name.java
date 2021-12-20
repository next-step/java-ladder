package ladder.domain.user;

public class Name {

    private final String name;

    public Name(String name) {
        if (name == null || name.trim().length() < 1 || name.trim().length() > 5) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하로 입력 해주세요");
        }

        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
