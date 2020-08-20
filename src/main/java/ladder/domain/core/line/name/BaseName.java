package ladder.domain.core.line.name;

abstract class BaseName {
    static final String ERROR_MESSAGE_REQUIRED_NAME = "참여하는 사람의 이름을 지정해 주세요.";
    protected final String name;

    protected BaseName(String name) {
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
