package nextstep.ladder.domain.person;

public class Name {
    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_LENGTH || name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 참여자의 이름은 1자 이상 5자 미만으로 설정해주세요.");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
