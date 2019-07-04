package ladder.domain;

import ladder.exception.DifferentRailCountException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Stream;

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
		ladder.rows.forEach(this::addRow);
	}

	public static Collector<HorizontalStepList, Ladder, Ladder> collector(){
		return Collector.of(
				Ladder::new,
				Ladder::addRow,
				(result1, result2) -> {
					result1.concat(result2);
					return result1;
				}
		);
	}

	public Stream<HorizontalStepList> getRows(){
		return Collections.unmodifiableList(rows).stream();
	}

}
