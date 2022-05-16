package nextstep.ladder.domain.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PeopleTest {

    @DisplayName("입력받은 이름을 바탕으로 참여자들을 생성한다.")
    @Test
    void createPeopleTest() {
        People people = People.of("포비,크롱,짱구,철수");
        System.out.println(people);
    }

    @DisplayName("입력받은 이름을 바탕으로 참여자들을 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"포비", ""})
    void createPeopleTestFail(String names) {
        assertThatThrownBy(() -> People.of(names))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
