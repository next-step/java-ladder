package domain;

import domain.dto.LadderLayerDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by hspark on 16/11/2018.
 */

/**
 * 1. 라인의 갯수는 0개에서 사다리 폭(인원수 -1개)까지이다.
 * 2. 라인을 만들 때, 좌/우에는 라인이 없어야한다.
 * 3. 직전에 라인을 그렸으면 다음 라인은 패스한다.
 * 3. 라인제네레이터는 해당 라인에 선을 그을지  true/false 만을 반환한다.
 * 4. LadderLayer에 Payer를 넘겨 이동 가능한 LadderLine을 받는다.
 */

public class LadderLayerTest {

	@Test(expected = IllegalArgumentException.class)
	public void test_너비음수_에러() {
		LadderLayer ladderLayer = new LadderLayer(-1, () -> true);
		ladderLayer.drawLines();
	}

	@Test
	public void test_너비0_라인미생성() {
		LadderLayer ladderLayer = new LadderLayer(0, () -> true);
		ladderLayer.drawLines();
		LadderLayerDTO ladderLineDTO = ladderLayer.getLadderLineDTO();
		Assertions.assertThat(ladderLineDTO.getLineDTOList()).hasSize(0);
	}

	@Test
	public void test_너비1_라인한개() {
		LadderLayer ladderLayer = new LadderLayer(1, () -> true);
		ladderLayer.drawLines();
		LadderLayerDTO ladderLineDTO = ladderLayer.getLadderLineDTO();
		Assertions.assertThat(ladderLineDTO.getLineDTOList()).hasSize(1);
		Assertions.assertThat(ladderLineDTO.getLineDTOList()).extracting("drawn").contains(true);
	}

	@Test
	public void test_너비3_이어지는_라인_없음() {
		LadderLayer ladderLayer = new LadderLayer(3, () -> true);
		ladderLayer.drawLines();
		LadderLayerDTO ladderLineDTO = ladderLayer.getLadderLineDTO();
		Assertions.assertThat(ladderLineDTO.getLineDTOList()).hasSize(3);
		Assertions.assertThat(ladderLineDTO.getLineDTOList()).extracting("drawn").contains(true, false, true);
	}

	@Test
	public void test_이동가능한_LadderLine획득() {
		LadderLayer ladderLayer = new LadderLayer(3, () -> true);
		ladderLayer.drawLines();

		Gamer gamer = new Gamer("test", 0);
		Optional<LadderLine> ladderLine = ladderLayer.getPassableLadderLine(gamer);

		Assertions.assertThat(ladderLine.isPresent()).isTrue();
		Assertions.assertThat(ladderLine.get().isPassable(gamer.getPosition())).isTrue();
	}
}
