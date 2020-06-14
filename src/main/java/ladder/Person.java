package ladder;

public class Person {
    public static final int MAX_NAME_LENGTH = 5;
    String name;

    private Person(String name) {
        checkedNameLength(name);
        this.name = name;
    }

    public static Person create(String name) {
        return new Person(name);
    }

    private void checkedNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자 까지 가능 합니다.");
        }
    }
}
