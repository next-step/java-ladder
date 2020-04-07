package JavaLadder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class GameInformationTest {
    @Test
    public void userAndPrizeValueTest() {
        String name = "test1,test2";
        String prize = "test1";
        assertThatThrownBy(() -> { new GameInformation(name, prize);}).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사용자수[2]와 상품수[1]가 동일해야합니다.");
    }

    @Test
    public void getValueTest() {
        String name = "test1,test2";
        String prize = "prize1,prize2";
        GameInformation gameInformation = new GameInformation(name, prize);
        assertThat(gameInformation.getUser()).isEqualTo(new Users(name));
        assertThat(gameInformation.getPrizes()).isEqualTo(new Prizes(prize));
    }
}
