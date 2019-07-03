package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
	private List<HorizontalStepList> rows;

	public Ladder(){
		rows = new ArrayList<>();
	}

	public void addRow(HorizontalStepList row){
		rows.add(row);
	}
}
