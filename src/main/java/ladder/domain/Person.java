package ladder.domain;

public class Person {
    private final String name;

    public Person(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("공백을 제외한 이름을 한글자 이상 입력해주세요.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("사람 이름은 최대5글자까지 입니다.");
        }
    }

    public String getName() {
        return name;
    }
}
