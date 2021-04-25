package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.exception.OutOfNameLengthException;
import step02.user.Name;
import step02.user.Users;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    @DisplayName("쉼표 구분으로 각 Name 객체 생성 테스트")
    void splitNameTest() throws OutOfNameLengthException {
        List<Name> names = Users.splitName("user1,user2,user3");
        assertThat(names).contains(new Name("user1")).contains(new Name("user2")).contains(new Name("user3"));
    }


    @Test
    @DisplayName("이름 길이 체크")
    void checkNameLength() {
        assertThatThrownBy(() -> {
            Name.checkNameLength("");
        }).isInstanceOf(IllegalAccessException.class)
                .hasMessage("이름은 1~5글자 이내로 입력해주세요");
    }

}
