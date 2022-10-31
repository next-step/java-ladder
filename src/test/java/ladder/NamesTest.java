package ladder;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import ladder.exception.EmptyNamesException;
import ladder.exception.InvalidNameLengthException;
import ladder.exception.NullNamesException;
import ladder.exception.UnknownNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesTest {

    @Test
    @DisplayName("이름들 등록하기.")
    void init_names() {
        assertDoesNotThrow(() -> new Names(List.of("pobi", "honux", "crong", "jk")));
    }

    @Test
    @DisplayName("이름들이 null 이면 예외 발생.")
    void fail_to_init_names_by_null_names() {
        assertThatExceptionOfType(NullNamesException.class)
                .isThrownBy(() -> new Names(null));
    }

    @Test
    @DisplayName("이름이 한개도 없으면 예외 발생.")
    void fail_to_init_names_by_empty_names() {
        assertThatExceptionOfType(EmptyNamesException.class)
                .isThrownBy(() -> new Names(new ArrayList<>()));
    }

    @Test
    @DisplayName("이름길이가 0 초과 5 이하가 아니면 예외 발생.")
    void fail_to_init_names_by_invalid_name_length() {
        assertAll(
                () -> assertThatExceptionOfType(InvalidNameLengthException.class)
                        .isThrownBy(() -> new Names(List.of("abcvsdgagh", "adgda", "adg"))),
                () -> assertThatExceptionOfType(InvalidNameLengthException.class)
                        .isThrownBy(() -> new Names(List.of("", "adgda", "adg")))
        );
    }

    @Test
    @DisplayName("이름의 인덱스를 구하기.")
    void get_index_by_name() {
        Names names = new Names(List.of("pobi", "honux", "crong", "jk"));
        assertDoesNotThrow(() -> names.getIndex("pobi"));
    }

    @Test
    @DisplayName("존재하지 않는 이름의 인덱스를 구하려면 예외 발생.")
    void fail_to_get_index_by_unknown_name() {
        Names names = new Names(List.of("pobi", "honux", "crong", "jk"));
        assertThatExceptionOfType(UnknownNameException.class)
                .isThrownBy(() -> names.getIndex("king"));
    }

}