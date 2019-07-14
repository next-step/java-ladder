package ladder.domain;

import ladder.exception.DifferentRailCountException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
	private List<HorizontalStepList> rows;

	public Ladder(int railCount, int height, StepProvider provider){
		rows = new ArrayList<>();

		IntStream.range(0, height)
			.forEach((i) -> addRow(new HorizontalStepList(railCount, provider)));

	}

	public void addRow(HorizontalStepList row){
		if(rows.size() > 0 && !rows.get(0).isAppendable(row)){
			throw new DifferentRailCountException();
		}

		rows.add(row);
	}

	public Stream<HorizontalStepList> getRows(){
		return Collections.unmodifiableList(rows).stream();
	}

	public int getResult(int startRail) {
		int result = startRail;
		for(int i = 0; i < rows.size(); i++){
			result = rows.get(i).getNextRailFrom(result);
		}
		return result;
	}
}
