package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class UserGeneratorTest {

    @DisplayName("사용자 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi, honux, crong, jk "})
    void testGenerateUsers(final String inputText) {
        UserGenerator userGenerator = new UserGenerator(inputText);

        assertThat(userGenerator.generateUsers()).hasSize(4);
    }
}
