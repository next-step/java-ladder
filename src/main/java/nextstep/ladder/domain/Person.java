package nextstep.ladder.domain;

public class Person {

    private String name;

    public Person(String name) {
        if (5 < name.length()) {
            throw new RuntimeException("사람이름은 최대 5자입니다.");
        }
        this.name = name;
    }

    public String name() {
        return this.name;
    }
}
