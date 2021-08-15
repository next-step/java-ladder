package ladder.model;

import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

	@Test
	@DisplayName("라인의 출력여부값들을 입력하면 라인이 생성된다.")
	public void createLine(){
		Line line = new Line(getPoints());

		assertThat(line).isEqualTo(new Line(getPoints()));
	}

	private List<Boolean> getPoints() {
		List<Boolean> points = new ArrayList<>();
		points.add(false);
		points.add(false);
		points.add(true);
		return points;
	}

}