package ladder;

public class Name {

    private String name;

    public Name(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }
}
