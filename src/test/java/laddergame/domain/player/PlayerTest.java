package laddergame.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import laddergame.domain.player.Player;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class PlayerTest {

	@Test(expected = IllegalArgumentException.class)
	public void 플레이어명은_최대5자까지_가능() {
		new Player("hongsi");
	}

	@Test
	public void 플레이어명은_최대길이를_기준으로_오른쪽정렬_출력() {
		Player player1 = new Player("crong");
		Player player2 = new Player("jk");

		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(player1.getFomattedName()).as("5자").isEqualTo("crong");
		softAssertions.assertThat(player2.getFomattedName()).as("2자").isEqualTo("   jk");
		softAssertions.assertAll();
	}

	@Test
	public void 같은_이름일때_검증() {
		Player player = new Player("hong");

		assertThat(player.isSameName("hong")).isTrue();
	}

	@Test
	public void 다른_이름일때_검증() {
		Player player = new Player("hong");

		assertThat(player.isSameName("11")).isFalse();
	}
}