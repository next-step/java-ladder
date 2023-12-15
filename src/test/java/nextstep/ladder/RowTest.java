package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Row;
import nextstep.ladder.domain.Width;

public class RowTest {
	@DisplayName("width에 맞게 ladder row가 생성됩니다.")
	@Test
	void validate_create_row() {
		Assertions.assertThat(new Row(new Width(5)).values().size())
			.isEqualTo(5);
	}

	@DisplayName("항상 right point 오른쪽에는 left point가 위치합니다.")
	@Test
	void validate_pair() {
		Row row = new Row(new Width(20));
		List<Point> rowValues = row.values();
		for (int i = 0; i < rowValues.size(); i++) {
			if (row.values().get(i).isRight()) {
				Assertions.assertThat(rowValues.get(i+1)).isEqualTo(Point.LEFT);
			}
		}
	}
}
