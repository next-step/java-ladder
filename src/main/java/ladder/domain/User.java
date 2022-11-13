package ladder.domain;

public class User {
    public static final int MAX_NAME_SIZE = 5;
    
    private final String name;

    public User(final String name) {
        if (name == null || name.isBlank() || name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("The maximum length of a name cannot exceed "+ MAX_NAME_SIZE +" characters.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equalsByName(User user) {
        return name.equals(user.name);
    }
}
