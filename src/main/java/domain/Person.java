package domain;

public class Person {
    private String name;

    public Person(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자까지만 입력 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
