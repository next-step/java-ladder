package ladder.model;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	@DisplayName("플레이어에 이름을 입력하면 플레이어가 생긴다.")
	public void createPlayer(){
		Player player = new Player(new Name("cross"));

		assertThat(player).isEqualTo(new Player(new Name("cross")));
	}

	@Test
	@DisplayName("플레이어에 이름을 알수있다..")
	public void getPlayerName(){
		Player player = new Player(new Name("cross"));

		assertThat(player.toString()).isEqualTo(" cross");
	}

}