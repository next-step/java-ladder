package nextstep.ladder.domain;

public class User {

    public static final int MAXIMUM_NAME_LENGTH = 5;
    private final String name;
    private final String winningProduct;

    public static User from(String name, String winningProduct) {
        return new User(name, winningProduct);
    }

    private User(String name, String winningProduct) {
        validate(name);
        this.name = name;
        this.winningProduct = winningProduct;
    }

    private void validate(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("이름은 %d자 이하로 입력 해 주세요. 입력 이름 = \"%s\"", MAXIMUM_NAME_LENGTH, name));
        }
    }

    public String name() {
        return this.name;
    }

    public String winningProduct() {
        return this.winningProduct;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
