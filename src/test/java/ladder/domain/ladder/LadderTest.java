package ladder.domain.ladder;

import ladder.domain.ladder.point.ManualPointAdd;
import ladder.domain.ladder.point.PointEnum;
import ladder.domain.ladder.point.RandomPointAdd;
import ladder.domain.result.Results;
import ladder.domain.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

	@DisplayName("높이와 사람과 결과값을 입력하면 사다리를 생성한다.")
	@Test
	void createLadder() {
		// given
		int height = 5;
		Users users = new Users("a,b,c,d,e");
		Results results = new Results("꽝,5000,꽝,3000,꽝", 5);


		// when
		Ladder ladder = Ladder.createLadder(Height.createHeight(height), users, results, new RandomPointAdd());

		// then
		assertThat(ladder.getHeight()).isEqualTo(5);
	}

	@DisplayName("사다리를 생성하고 원하는 사람의 결과값을 출력한다.")
	@Test
	void resultForDesiredPerson() {
		// given
		Height height = Height.createHeight(5);
		Users users = new Users("pobi,honux,crong,jk");
		Results results = new Results("꽝,5000,꽝,3000", users.getCountOfPerson());

		/**
		 *
		 * pobi  honux crong   jk
		 *     |-----|     |-----|012 0123
		 *     |     |-----|     |345 4567
		 *     |-----|     |     |678 89011
		 *     |     |-----|     |91011 12131415
		 *     |-----|     |-----|121314 16171819
		 * 꽝    5000  꽝    3000
		 */
		List<PointEnum> points = new ArrayList<>();
		points.add(PointEnum.TRUE);
		points.add(PointEnum.FALSE);
		points.add(PointEnum.TRUE);
		points.add(PointEnum.FALSE);
		points.add(PointEnum.TRUE);
		points.add(PointEnum.FALSE);
		points.add(PointEnum.TRUE);
		points.add(PointEnum.FALSE);
		points.add(PointEnum.FALSE);
		points.add(PointEnum.FALSE);
		points.add(PointEnum.TRUE);
		points.add(PointEnum.FALSE);
		points.add(PointEnum.TRUE);
		points.add(PointEnum.FALSE);
		points.add(PointEnum.TRUE);

		// when
		Ladder ladder = Ladder.createLadder(height, users, results, new ManualPointAdd(points));


		// then
		assertThat(ladder.getMatchResult("honux")).isEqualTo("3000");
	}
}
