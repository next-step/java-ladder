package ladder.domain;

public class User {
    private final String name;

    public User(String name, int maxNameSize) {
        if (name == null || name.isBlank() || name.length() > maxNameSize) {
            throw new IllegalArgumentException("The maximum length of a name cannot exceed "+ maxNameSize +" characters.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
