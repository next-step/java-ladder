package nextstep.optional;

import java.util.Objects;
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

    /**
     * nextstep.optional.User 의 ageIsInRange1() 메소드는 30살 이상, 45살 이하에 해당하는 User 가 존재하는 경우 true 를 반환하는 메소드이다.
     * 같은 기능을 Optional 을 활용해 ageIsInRange2() 메소드에 구현한다.
     * 메소드 인자로 받은 User 를 Optional 로 생성하면 stream 의 map, filter 와 같은 메소드를 사용하는 것이 가능하다.
     * nextstep.optional.UserTest 의 테스트가 모두 pass 해야 한다.
     */
    public static boolean ageIsInRange2(User user) {
        if(Optional.ofNullable(user).isPresent()) {
            return Optional.ofNullable(user.getAge())
                    .filter(u -> (u >= 30 && u <= 45))
                    .isPresent();
        }
        return false;

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
