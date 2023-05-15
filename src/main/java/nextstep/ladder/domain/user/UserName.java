package nextstep.ladder.domain.user;

import nextstep.ladder.domain.formatter.Format;
import nextstep.ladder.domain.formatter.NameFormat;

import java.util.Objects;

public class UserName {

    private static final int MAX_LENGTH = 5;
    private static final String USER_ALL = "all";

    private final String name;
    private final Format format;

    private UserName(String name) {
        this(name, new NameFormat());
    }

    public UserName(String name, Format format) {
        this.name = name;
        this.format = format;
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

    public String getName() {
        return name;
    }

    public String formattedName() {
        return format.formalize(name);
    }

    public boolean isAll() {
        return USER_ALL.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(name, userName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
