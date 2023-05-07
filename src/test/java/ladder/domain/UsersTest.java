package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UsersTest {

    private Users users;

    @BeforeEach
    public void beforeEach() {
        User kilby = new User("kilby");
        User david = new User("Dawon-Kahng");
        User feynman = new User("feynman");
        users = new Users(List.of(kilby, david, feynman));
    }


    @DisplayName("관리하는 user 수를 리턴한다")
    @Test
    public void count() {
        //given
        //when
        int count = users.count();
        //then
        assertThat(count).as("").isEqualTo(3);
    }

    @DisplayName("모든 유저의 이름을 가져온다")
    @Test
    public void names() {
        //given
        //when
        List<String> names = users.names();
        //then
        assertThat(names).as("").contains("kilby");
        assertThat(names).as("").contains("Dawon-Kahng");
        assertThat(names).as("").contains("feynman");
    }
}