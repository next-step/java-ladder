package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("")
public class LadderTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi","honux","crong","jk"})
    @DisplayName("이름을 입력받아 확인하는 테스트")
    void inputStringNameTest(String name) {
        String names = "pobi,honux,crong,jk";
        Ladder ladder = new Ladder(names);
        List<String> nameList = ladder.getNames();
        assertThat(nameList).contains(name);
    }

    @Test
    @DisplayName("이름이 5자가 넘으면 에러가 나는 테스트")
    void validateNameLengthTest() {
        String names = "pobi12,honux1,crong1,jk1234";
        assertThatIllegalArgumentException().isThrownBy(() -> new Ladder(names));
    }

}
