package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UsersTest {


    @DisplayName("관리하는 user 수를 리턴한다")
    @Test
    public void count() {
        //given
        User kilby = new User("kilby");
        User david = new User("Dawon-Kahng");
        User feynman = new User("feynman");
        Users users = new Users(List.of(kilby, david, feynman));
        //when
        int count = users.count();
        //then
        assertThat(count).as("").isEqualTo(3);
    }
}