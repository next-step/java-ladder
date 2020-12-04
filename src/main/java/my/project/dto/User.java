package my.project.dto;

import java.util.Optional;
import java.util.regex.Pattern;

public class User {
    public static final String USER_PATTERN = "^([A-z0-9,]{0,5})$";
    public static final String INPUT_USER_ALERT = "사용자명을 확인해주십시요.(최대 5자)";

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        validateName(name);
        this.name = name;
        this.age = age;
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
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public boolean matchName(String name) {
        return this.name.equals(name);
    }

    public static boolean ageIsInRange1(User user) {
        boolean isInRange = false;

        if (user != null && user.getAge() != null
                && (user.getAge() >= 30
                && user.getAge() <= 45)) {
            isInRange = true;
        }
        return isInRange;
    }

    public static boolean ageIsInRange2(User user) {
        return Optional.ofNullable(user)
                .map(User::getAge)
                .filter(u -> u >= 30)
                .filter(u -> u <= 45)
                .isPresent();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
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
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
