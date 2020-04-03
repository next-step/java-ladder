package nextstep.optional;

import java.util.Optional;

import static java.util.Optional.ofNullable;

public class User {
    private static final int AGE_CONDITION = 0;
    private static final String NULL_BLANK = "";
    private static final int THIRTY = 30;
    private static final int FORTY_FIVE = 45;

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
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
        Optional<User> optionalUser = ofNullable(user);
        if (optionalUser.isPresent()) {
            return optionalUser
                    .map(User::graterThanEqualThirty)
                    .map(e -> User.lessThanEqualFortyFive(e.orElseGet(() -> new User(NULL_BLANK, AGE_CONDITION))))
                    .map(e -> e.orElseGet(() -> new User(NULL_BLANK, AGE_CONDITION)).getAge())
                    .orElseGet(() -> AGE_CONDITION) != AGE_CONDITION;
        }
        return false;
    }

    public static boolean ageIsInRange2(User user) {
        return ofNullable(user)
                .map(User::getAge)
                .filter(User::isGraterThanEqualThirty)
                .filter(User::isLessThanEqualFortyFive)
                .orElse(AGE_CONDITION) != AGE_CONDITION;
    }

    private static boolean isGraterThanEqualThirty(int age) {
        return age >= THIRTY;
    }

    private static boolean isLessThanEqualFortyFive(int age) {
        return age <= FORTY_FIVE;
    }

    private static Optional<User> graterThanEqualThirty(User user) {
        Optional<Integer> optionalAge = ofNullable(user.getAge());
        if (optionalAge.orElseGet(() -> AGE_CONDITION) >= THIRTY) {
            return Optional.of(user);
        }
        return Optional.empty();
    }

    private static Optional<User> lessThanEqualFortyFive(User user) {
        Optional<Integer> optionalAge = ofNullable(user.getAge());
        if (optionalAge.orElseGet(() -> AGE_CONDITION) <= FORTY_FIVE) {
            return Optional.of(user);
        }
        return Optional.empty();
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
