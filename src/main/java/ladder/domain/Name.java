package ladder.domain;

public class Name {
    private String name;

    public Name(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5자까지 입력할 수 있습니다. name : " + name);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
