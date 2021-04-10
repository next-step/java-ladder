package nextstep.optional;

import java.util.Optional;

public final class User {

    public static final int MINIMUM_AGE = 30;
    public static final int MAXIMUM_AGE = 45;

    private final String name;
    private final Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public final String getName() {
        return name;
    }

    public final Integer getAge() {
        return age;
    }

    public final boolean matchName(String name) {
        return this.name.equals(name);
    }

    public static final boolean ageIsInRange1(User user) {
        boolean isInRange = false;

        // 해당 메서드를 기준으로 새로운 메서드를 만드므로 수정 x
        if (user != null && user.getAge() != null
                && (user.getAge() >= 30
                && user.getAge() <= 45)) {
            isInRange = true;
        }
        return isInRange;
    }

    public static final boolean ageIsInRange2(User user) {
        return Optional.ofNullable(user)
                .map(User::getAge)
                .filter(User::isAgeInRange)
                .isPresent();
    }

    private static final boolean isAgeInRange(Integer age) {
        return age >= MINIMUM_AGE && age <= MAXIMUM_AGE;
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
