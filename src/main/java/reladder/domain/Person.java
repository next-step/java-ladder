package reladder.domain;

import java.util.List;

public class Person {

    private static final int NAME_MAX_LENGTH = 6;
    private static final int NAME_LENGTH = 5;

    private String name;
    private int position;

    Person(String name, int position) {
        this.name = name;
        this.position = position;
        validate();
    }

    boolean findNameContainsExactly(String name) {
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

        if (this.position < 0) {
            throw new IllegalArgumentException();
        }
    }
}
