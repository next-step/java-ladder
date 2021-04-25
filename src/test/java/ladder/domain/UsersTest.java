package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
public class UsersTest {

    @Test
    @DisplayName("중복된 User가 있으면 에러코드 내는지 테스트")
    void duplicationUserTest(){
        List<User> userList = Arrays.asList(new User("test"),new User("test"));

        assertThatThrownBy(()->{
            Users users = new Users(userList);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("중복된 User가 있습니다.");
    }

    @Test
    @DisplayName("중복된 User가 없을 때 에러코드 내지 않는지 테스트")
    void NotDuplicationUserTest(){
        List<User> userList = Arrays.asList(new User("test"),new User("test2"));

        Users users = new Users(userList);
        assertThat(userList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("중복된 User가 있으면 에러코드 내는지 테스트")
    void duplicationUserTest2(){
        List<User> userList = Arrays.asList(new User("test"),new User("test"));

        assertThatThrownBy(()->{
            Users users = new Users(userList);
            users.checkDuplicateUser2();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("중복된 User가 있습니다.");
    }

}
