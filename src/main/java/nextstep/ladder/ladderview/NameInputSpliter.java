package nextstep.ladder.ladderview;

import java.util.function.UnaryOperator;

public class NameInputSpliter implements UnaryOperator<String> {
    private static NameInputSpliter splitNameInput;

    public static NameInputSpliter getInstance() {
        if (splitNameInput == null) {
            splitNameInput = new NameInputSpliter();
        }
        return splitNameInput;
    }

    private NameInputSpliter() {
    }

    @Override
    public String apply(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5자를 초과할 수 없습니다");
        }
        return name;
    }
}
