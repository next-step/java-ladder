package ladder.domain;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        if(name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("name length should be less than 5.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
