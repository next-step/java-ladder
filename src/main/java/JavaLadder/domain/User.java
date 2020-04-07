package JavaLadder.domain;

public class User {
    private String name = "";

    public User(String name) {
        validateSize(name);
        this.name = name;
    }

    private void validateSize(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("[" + name + "]: 5자리 이하만 입력가능합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
