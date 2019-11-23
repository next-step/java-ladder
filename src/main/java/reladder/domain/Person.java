package reladder.domain;

public class Person {

    private static final int NAME_MAX_LENGTH = 6;
    private static final int NAME_LENGTH = 5;
    private static final int MIN_LENGTH = 0;

    private String name;
    private int position;

    Person(String name, int position) {
        this.name = name;
        this.position = position;
        validate();
    }

    boolean matchNameContainsExactly(String name) {
        return this.name.equals(name);
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    public int getEmptyLength() {
        return NAME_MAX_LENGTH - name.length();
    }

    public boolean isNameLength() {
        return this.name.length() <= NAME_LENGTH;
    }

    private void validate() {
        if (this.name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException();
        }

        if (this.position < MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
