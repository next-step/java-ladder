package nextstep.ladder;

public class Person {

    private final String name;
    private final static int MAX_SIZE = 5;

    public Person(String name) {
        if (name.length() > MAX_SIZE) {
            throw new IllegalArgumentException("사람의 이름은 최대 5글자");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
