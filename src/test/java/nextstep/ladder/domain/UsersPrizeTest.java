package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("UsersPrize: 참여자와 사다리타기 결과를 이어주는 로직 테스트")
class UsersPrizeTest {

    @DisplayName("추가한 유저, 결과 상품 리스트를 가져올 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"pobi,꽝", "honux,3000", "crong,꽝", "jk,5000"}, delimiter = ',')
    public void add_WithUserAndPrize_IsSuccess(String userName, String prize) {
        UsersPrize usersPrize = new UsersPrize();
        Prize expected = new Prize(prize);
        usersPrize.add(new User(userName), expected);
        assertThat(usersPrize.getPrize(userName)).isEqualTo(expected);
    }
}
