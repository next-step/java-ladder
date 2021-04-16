package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PrizesTest {

    @Test
    @DisplayName("결과 목록을 입력받아 결과 객체들을 생성한다.")
    public void create() throws Exception {
        Prizes prizes = new Prizes(2, "꽝", "5000");
        List<Prize> allPrizes = prizes.allPrizes();
        assertThat(allPrizes).containsExactly(new Prize("꽝"), new Prize("5000"));
    }

    @Test
    @DisplayName("결과 목록이 플레이어 인원 수보다 많거나 적을 경우 예외가 발생한다.")
    public void validateLength() throws Exception {
        Players players = new Players("pobi", "tobi", "dobi", "kobi");

        assertThatIllegalArgumentException().isThrownBy(() ->
                new Prizes(players.countOfPlayer(), "this", "is", "less"))
                .withMessage("결과 목록의 길이는 플레이어 목록의 길이와 같아야합니다.");

        assertThatIllegalArgumentException().isThrownBy(() ->
                new Prizes(players.countOfPlayer(), "this", "is", "greater", "than", "players"))
                .withMessage("결과 목록의 길이는 플레이어 목록의 길이와 같아야합니다.");
    }
}
