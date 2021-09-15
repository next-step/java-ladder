package step4.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    @DisplayName("name 생성 테스트")
    void createNameTest() {

        // given
        String input = "PJS";

        // when
        Name result = Name.of(input);

        // then
        assertThat(result).isEqualTo(Name.of(input));
    }
}
