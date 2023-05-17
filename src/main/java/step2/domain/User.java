package step2.domain;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getFiveCharacterName() {
        if (name.length() < 5) {
            return String.format("%-5s", name);
        }
        return name.substring(0, 5);
    }
}
