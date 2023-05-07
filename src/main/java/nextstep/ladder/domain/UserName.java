package nextstep.ladder.domain;

import nextstep.ladder.domain.formatter.Formatter;
import nextstep.ladder.domain.formatter.NameFormatter;

public class UserName {

    private static final int MAX_LENGTH = 5;

    private final String name;
    private final Formatter formatter;

    private UserName(String name) {
        this(name, new NameFormatter());
    }

    public UserName(String name, Formatter formatter) {
        this.name = name;
        this.formatter = formatter;
    }

    public static int getMaxLength() {
        return MAX_LENGTH;
    }

    public static UserName add(String name) {
        validate(name);
        return new UserName(name);
    }

    private static void validate(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("사용자명은 최소 1자 입니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("사용자명은 최대 %s자 입니다.", MAX_LENGTH));
        }
    }

    public String formattedName() {
        return formatter.format(name);
    }

}
