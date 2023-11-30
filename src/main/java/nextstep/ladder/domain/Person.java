package nextstep.ladder.domain;

public class Person {

    String name;

    public Person(String name) throws Exception {
        if (5 < name.length()) {
            throw new Exception("사람이름은 최대 5자입니다.");
        }
        this.name = name;
    }
}
