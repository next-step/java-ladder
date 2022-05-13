package nextstep.ladder.domain.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersFactoryTest {
    @Test
    @DisplayName("문자열에 쉼표를 기준으로 User 객체를 만들고 Users 를 반환한다.")
    void create() {
        assertThat(UsersFactory.newInstance("a,b,c,d,e").size()).isEqualTo(5);
    }
}
