package ladder.domain;

import ladder.exception.DifferentRailCountException;

import java.util.ArrayList;
import java.util.List;

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

	public int size() {
		return 0;
	}
}
