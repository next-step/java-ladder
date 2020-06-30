package nextstep.ladder.domain;

import nextstep.ladder.domain.tobe.Ladder;
import nextstep.ladder.domain.tobe.fixture.FixedLineCreateStrategy;
import nextstep.ladder.domain.tobe.fixture.PrizesFixture;
import nextstep.ladder.domain.tobe.fixture.UsersFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("UsersPrize: 참여자와 사다리타기 결과를 이어주는 로직 테스트")
class UsersPrizeTest {

    @DisplayName("유저, 결과 상품 리스트를 가져올 수 있다")
    @Test
    public void add_WithUserAndPrize_IsSuccess() {
        UsersPrize usersPrize = new UsersPrize(UsersFixture.TestUsers, PrizesFixture.TestPrizes, new Ladder(5, 4, new FixedLineCreateStrategy()));
        assertAll(
                () -> assertThat(usersPrize.getPrize(UsersFixture.TestUsers.getUser(0).getName())).isEqualTo("꽝"),
                () -> assertThat(usersPrize.getPrize(UsersFixture.TestUsers.getUser(1).getName())).isEqualTo("3000"),
                () -> assertThat(usersPrize.getPrize(UsersFixture.TestUsers.getUser(2).getName())).isEqualTo("꽝"),
                () -> assertThat(usersPrize.getPrize(UsersFixture.TestUsers.getUser(3).getName())).isEqualTo("5000"));
    }
}
