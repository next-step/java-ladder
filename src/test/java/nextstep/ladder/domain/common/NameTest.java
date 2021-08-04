package nextstep.ladder.domain.common;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.domain.common.exception.InvalidNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("이름")
class NameTest {

    @DisplayName("[성공] 생성")
    @ParameterizedTest
    @CsvSource(value = {
        "pobi", "honux", "crong", "jk"
    })
    public void create(String name) {
        // given

        // when
        Name createName = Name.of(name);

        // then
        assertThat(createName.getName()).isEqualTo(name);
    }

    @DisplayName("[실패] 생성")
    @ParameterizedTest
    @CsvSource(value = {
        "honux1"
    })
    public void create_invalidName(String name) {
        // given

        // when
        Assertions.assertThrows(InvalidNameException.class, () -> Name.of(name));

        // then
    }
}
