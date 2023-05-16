package nextstep.ladder.domain;

public class User {

    private static final int USER_NAME_MIN_LENGTH = 1;
    private static final int USER_NAME_MAX_LENGTH = 5;
    private final String name;
    private String result;

    public User(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public void validateNameLength(String name) {
        if (name.length() < USER_NAME_MIN_LENGTH || name.length() > USER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("참가자 이름은 1자이상 5자 이하");
        }
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }
}
