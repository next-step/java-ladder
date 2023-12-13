package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rows {
	private final List<Row> rows;

	public Rows(List<Row> rows) {
		this.rows = rows;
	}

	public Rows(Width width, Height height) {
		rows = new ArrayList<>();
		for (int idx = 0; idx < height.value(); idx++) {
			rows.add(new Row(width));
		}
	}

	public List<Row> values() {
		return Collections.unmodifiableList(rows);
	}
}
