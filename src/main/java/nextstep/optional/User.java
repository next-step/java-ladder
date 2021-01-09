package nextstep.optional;

import java.util.Optional;

public class User {
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
        boolean isInRange = false;

        if (user != null && user.getAge() != null
                && (user.getAge() >= 30
                && user.getAge() <= 45)) {
            isInRange = true;
        }
        return isInRange;
    }

    // map이 변환하여 추출 해주는 건데 age가 null일 경우 empty(new Opitonal)인데
    // 어떻게 age -> age >= 30와 같은 연산이 될까?
    public static boolean ageIsInRange2(User user) {
        return Optional.ofNullable(user)
                .map(User::getAge)
                .filter(age -> age >= 30)
                .filter(age -> age <= 45)
                .isPresent();
    }

    // age가 null이면 NPE가 발생하는 현상
    // 즉 null >= 30 과 같은 수식이 불가능 공 해보자
    public static boolean ageIsInRange3(User user) {
        return Optional.ofNullable(user)
                .filter(u -> u.getAge() >= 30)
                .filter(u -> u.getAge() <= 40)
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
