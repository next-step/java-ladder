package ladder.domain.ladder;

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
		Ladder ladder = Ladder.createLadder(height, users, results, new RandomPointLines());

		// then
		assertThat(ladder.getHeight()).isEqualTo(5);
	}

	@DisplayName("사다리를 생성하고 원하는 사람의 결과값을 출력한다.")
	@Test
	void resultForDesiredPerson() {
		// given
		int height = 5;
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
		List<List<PointEnum>> pointArrayList = new ArrayList<>();

		List<PointEnum> points1 = new ArrayList<>();
		points1.add(PointEnum.TRUE);
		points1.add(PointEnum.FALSE);
		points1.add(PointEnum.TRUE);

		List<PointEnum> points2 = new ArrayList<>();
		points2.add(PointEnum.FALSE);
		points2.add(PointEnum.TRUE);
		points2.add(PointEnum.FALSE);

		List<PointEnum> points3 = new ArrayList<>();
		points3.add(PointEnum.TRUE);
		points3.add(PointEnum.FALSE);
		points3.add(PointEnum.FALSE);

		List<PointEnum> points4 = new ArrayList<>();
		points4.add(PointEnum.FALSE);
		points4.add(PointEnum.TRUE);
		points4.add(PointEnum.FALSE);

		List<PointEnum> points5 = new ArrayList<>();
		points5.add(PointEnum.TRUE);
		points5.add(PointEnum.FALSE);
		points5.add(PointEnum.TRUE);

		pointArrayList.add(points1);
		pointArrayList.add(points2);
		pointArrayList.add(points3);
		pointArrayList.add(points4);
		pointArrayList.add(points5);

		Lines lines = Lines.createManualLines(height, users.getCountOfPerson(), pointArrayList);
		// when
		Ladder ladder = new Ladder(Height.createHeight(height), users, results, lines);

		// then
		assertThat(ladder.getMatchResult("jk")).isEqualTo("5000");
	}
}
