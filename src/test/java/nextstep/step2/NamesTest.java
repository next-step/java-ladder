package nextstep.step2;

import nextstep.step2.domain.Name;
import nextstep.step2.domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Names 클래스 테스트")
public class NamesTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "honux", "crong", "jk"})
    @DisplayName("names가 잘 셋팅 되었는지 확인")
    void namesTest(String input) {
        String nameString = "pobi,honux,crong,jk";
        Names names = new Names(nameString);
        assertThat(names.getNames()).contains(new Name(input));
    }
}
