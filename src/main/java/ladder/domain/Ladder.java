package ladder.domain;

import ladder.exception.DifferentRailCountException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

public class Ladder {
	private List<HorizontalStepList> rows;

	public Ladder(){
		rows = new ArrayList<>();
	}

	public void addRow(HorizontalStepList row){
		if(rows.size() > 0 && !rows.get(0).isAppendable(row)){
			throw new DifferentRailCountException();
		}

		rows.add(row);
	}

	private void concat(Ladder ladder) {
		ladder.rows.stream()
				.forEach(this::addRow);
	}

	public boolean hasStepLeftAt(int row, int rail){
		return rows.get(row).hasLeftStepAt(rail);
	}

	public static Collector<HorizontalStepList, Ladder, Ladder> collector(){
		return Collector.of(
				() -> new Ladder(),
				(result, row) -> result.addRow(row),
				(result1, result2) -> {
					result1.concat(result2);
					return result1;
				}
		);
	}

	public int height() {
		return rows.size();
	}

	public int railCount() {
		return Optional.ofNullable(rows.get(0))
				.orElse(new HorizontalStepList(0, null))
				.getRailCount();
	}
}
