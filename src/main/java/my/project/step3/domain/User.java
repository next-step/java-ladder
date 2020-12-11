package my.project.step3.domain;

import java.util.regex.Pattern;

public class User {
    public static final int MAX_LENGTH = 5;
    public static final String USER_PATTERN = "^([A-z0-9ㄱ-ㅎㅏ-ㅣ가-힣,]{1," + MAX_LENGTH + "})$";
    public static final String INPUT_USER_ALERT = "사용자명을 확인해주십시요.(최대 " + MAX_LENGTH + "자)";
    public static final int USER_START_POINT_MULTIPLE = 2;
    public static final int FIRST_LINE = 0;

    private final String name;
    private Point point;

    public User(String name, int x) {
        validateName(name);
        this.name = name;
        this.point = new Point(x * USER_START_POINT_MULTIPLE, FIRST_LINE);
    }

    public User(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (!Pattern.matches(USER_PATTERN, name)) {
            throw new IllegalArgumentException(INPUT_USER_ALERT);
        }
    }

    public String getName() {
        return String.format("%-" + MAX_LENGTH + "s", name);
    }

    public String getNameValue() {
        return name;
    }

    public Point getPoint() {
        return this.point;
    }

    public boolean matchName(String name) {
        return this.name.equals(name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (name == null) {
            return other.name == null;
        } else return name.equals(other.name);
    }
}
