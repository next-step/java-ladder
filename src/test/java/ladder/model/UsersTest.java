package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class UsersTest {


    @Test
    void shouldMapLine() {
        List<HorizontalLine> horizontalLine = List.of(new HorizontalLine(List.of(new LineUnit(), new LineUnit(), new LineUnit())));
        Users users = new Users(List.of(userWithName("A"), userWithName("B"), userWithName("C")));

        users.addLine(horizontalLine);

        assertThat(users.hasLine()).isTrue();
    }

    @Test
    @DisplayName("추가하고자 하는 라인 행수와 유저 개수가 맞지 않을떄는 예외가 발생해야 합니다.")
    void shouldNotMapLine_whenDifferentNum() {
        List<HorizontalLine> horizontalLine = List.of(new HorizontalLine(List.of(new LineUnit(), new LineUnit(), new LineUnit())));
        Users users = new Users(List.of(userWithName("A"), userWithName("B")));

        assertThatThrownBy(() -> users.addLine(horizontalLine)).isInstanceOf(IllegalArgumentException.class);
    }

    private User userWithName(String name) {
        return new User(new UserName(name));
    }


}
