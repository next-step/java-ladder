package nextstep.ladder.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    void 사람은_최대_5자의_이름을_가진다() {
        // given
        String name = "5자 이상의 이름";

        // when, then
        assertThatThrownBy(() -> new Person(name)).isInstanceOf(Exception.class);
    }

    @Test
    void 성공_사람_생성() throws Exception {
        // given
        String name = "테스트";

        // when
        Person person = new Person(name);

        // then
        assertThat(person.name()).isEqualTo(name);
    }

}
