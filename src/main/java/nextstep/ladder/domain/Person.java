package nextstep.ladder.domain;

public class Person {
    public static final String PERSON_NAME_LENGTH_ERROR = "이름은 5자 이하로 입력해주세요.";
    private String name;

    public Person(String name) {
        assertPersonName(name);
        this.name = name;
    }

    private void assertPersonName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException(PERSON_NAME_LENGTH_ERROR);
        }
    }

    public String getName() {
        return name;
    }
}
