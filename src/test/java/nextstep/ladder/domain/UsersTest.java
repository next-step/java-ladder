package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UsersTest {

    @DisplayName("참여자 리스트를 List<String> 형태로 변환하여 반환 해준다.")
    @Test
    void getUsersStringListForPrint() {
        // given
        Users users = Users.from(List.of("poppy", "jetty"), List.of("1등", "2등"));

        // then
        assertThat(users.toNameList()).contains("poppy", "jetty");
    }

    @DisplayName("참여자가 2명 미만이면 인원부족으로 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenUserSizeIsLessThan2() {
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Users.from(List.of("one"), List.of("1등")));
    }

    @DisplayName("참여자의 수를 반환한다.")
    @Test
    void countParticipants() {
        // given
        Users users = Users.from(List.of("poppy", "jetty"), List.of("1등", "2등"));

        // then
        assertThat(users.countOfUsers()).isEqualTo(2);
    }

    @DisplayName("참가자의 우승 상품을 확인할 수 있다.")
    @Test
    void findWinningProduct() {
        // given
        Users users = Users.from(List.of("poppy", "jetty"), List.of("1등", "2등"));

        // then
        assertThat(users.getWinningProductOf("poppy")).isEqualTo("1등");
        assertThat(users.getWinningProductOf("jetty")).isEqualTo("2등");
    }

    @DisplayName("참가자 리스트에 없는 참가자를 입력하면 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionIfNotInList() {
        // given
        Users users = Users.from(List.of("poppy", "jetty"), List.of("1등", "2등"));

        // then
        Assertions.assertThatThrownBy(() -> users.getWinningProductOf("poppa"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
