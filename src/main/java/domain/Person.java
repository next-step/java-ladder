package domain;

public class Person {
    private String name;

    private static final String DEFAULT_NAME = "     ";
    private static final int NAME_MAX_LENGTH = 5;

    public Person(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    @Override
    public String toString() {
        int beforeBlank = (NAME_MAX_LENGTH - name.length()) / 2;
        int afterBlank = NAME_MAX_LENGTH - beforeBlank - name.length();

        return DEFAULT_NAME.substring(0, beforeBlank) + name + DEFAULT_NAME.substring(0, afterBlank);
    }
}
