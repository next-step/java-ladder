package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Row;
import nextstep.ladder.domain.Rows;

public class RowsTest {
	@DisplayName("특정 인덱스가 어떤 당첨 결과 인덱스로 연결되는지 계산한다.")
	@Test
	void validate_calc_result_index() {
		Rows rows = new Rows(
			List.of(
				new Row(
					List.of(Point.RIGHT, Point.LEFT, Point.HOLD)
				),
				new Row(
					List.of(Point.HOLD, Point.RIGHT, Point.LEFT)
				),
				new Row(
					List.of(Point.HOLD, Point.HOLD, Point.HOLD)
				)
			)
		);
		assertThat(rows.calcResultIndex(0)).isEqualTo(2);
		assertThat(rows.calcResultIndex(1)).isEqualTo(0);
		assertThat(rows.calcResultIndex(2)).isEqualTo(1);
	}
}
