package JavaLadder.domain;

public class User {
    private String name;

    public User(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if(name.length() > 5 ){
            throw new IllegalArgumentException("5자리이하만입력가능합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
