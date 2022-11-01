package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.exception.EmptyNamesException;
import ladder.domain.exception.InvalidNameLengthException;
import ladder.domain.exception.NullNamesException;
import ladder.domain.exception.UnknownNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UsersTest {

    @Test
    @DisplayName("유저들 등록하기.")
    void init_users() {
        assertDoesNotThrow(() -> new Users(List.of("pobi", "honux", "crong", "jk")));
    }

    @Test
    @DisplayName("이름들이 null 이면 예외 발생.")
    void fail_to_init_users_by_null_names() {
        assertThatExceptionOfType(NullNamesException.class)
                .isThrownBy(() -> new Users(null));
    }

    @Test
    @DisplayName("이름이 한개도 없으면 예외 발생.")
    void fail_to_init_users_by_empty_names() {
        assertThatExceptionOfType(EmptyNamesException.class)
                .isThrownBy(() -> new Users(new ArrayList<>()));
    }

    @Test
    @DisplayName("이름길이가 0 초과, 최대 허용 길이 이하가 아니면 예외 발생.")
    void fail_to_init_users_by_invalid_name_length() {
        assertAll(
                () -> assertThatExceptionOfType(InvalidNameLengthException.class)
                        .isThrownBy(() -> new Users(List.of("abcvsdgagh", "adgda", "adg"))),
                () -> assertThatExceptionOfType(InvalidNameLengthException.class)
                        .isThrownBy(() -> new Users(List.of("", "adgda", "adg")))
        );
    }

    @Test
    @DisplayName("이름의 인덱스를 구하기.")
    void get_index_by_name() {
        Users users = new Users(List.of("pobi", "honux", "crong", "jk"));

        assertAll(
                () -> assertThat(users.getIndex("pobi")).isEqualTo(0),
                () -> assertThat(users.getIndex("honux")).isEqualTo(1),
                () -> assertThat(users.getIndex("crong")).isEqualTo(2),
                () -> assertThat(users.getIndex("jk")).isEqualTo(3),
                () -> assertThatExceptionOfType(UnknownNameException.class)
                        .isThrownBy(() -> users.getIndex("king"))
        );
    }

}
