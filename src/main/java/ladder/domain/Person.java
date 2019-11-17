package ladder.domain;

public class Person {

    private static final int NAME_MAX_LENGTH = 6;
    private static final int NAME_LENGTH = 5;

    private String name;
    private int startIndex;
    private int resultIndex;

    public Person(String name, int startIndex) {
        this.name = name;
        this.startIndex = startIndex;
        this.resultIndex = 0;
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

    void validate() {
        if (this.name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
