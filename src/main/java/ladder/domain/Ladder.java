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

	/**
	 * 여러개의 HorizontalStep 개체를 합쳐 하나의 Ladder 개체로 반환하는 콜레터
	 * @return
	 */
	public static Collector<HorizontalStepList, Ladder, Ladder> collector(){
		return Collector.of(
				Ladder::new,
				Ladder::addRow,
				(ladderA, ladderB) -> {
					ladderA.concat(ladderB);
					return ladderA;
				}
		);
	}

	public Stream<HorizontalStepList> getRows(){
		return Collections.unmodifiableList(rows).stream();
	}

}
