package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderBody {

	private List<HorizontalStepList> rows;

	private LadderFooter footer;

	public LadderBody(int railCount, int height, StepProvider provider, LadderFooter footer){
		this.rows = IntStream.range(0, height)
			.mapToObj(index -> new HorizontalStepList(railCount, provider))
			.collect(Collectors.toList());

		this.footer = footer;
	}

	public Stream<HorizontalStepList> getRows(){
		return Collections.unmodifiableList(rows).stream();
	}

	public String getResult(int startRail) {
		int result = startRail;

		for(int i = 0; i < rows.size(); i++){
			result = rows.get(i).getNextRailFrom(result);
		}

		return this.footer.getGoal(result);
	}
}
