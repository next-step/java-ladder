package ladder.domain.core.line.name;

public abstract class BaseName {
    static final String ERROR_MESSAGE_REQUIRED_NAME = "이름을 지정해 주세요.";
    protected final String name;

    protected BaseName(String name) {
        verifyBlankName(name);
        this.name = name;
    }

    static void verifyBlankName(String name) {
        if (null == name || "".equals(name.trim())) {
            throw new IllegalArgumentException(ERROR_MESSAGE_REQUIRED_NAME);
        }
    }

    String getName() {
        return name;
    }
}
