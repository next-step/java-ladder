package ladder.model;

public class Name {

    private final static int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        checkValidation(name);
        this.name = name;
    }

    private void checkValidation(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름이 null 이거나 비어있습니다.");
        }
        if(name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름 길이는 " + MAX_LENGTH + "를 넘으면 안됩니다.");
        }
    }
}