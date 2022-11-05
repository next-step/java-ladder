package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {
	private final List<Line> lines;

	public Lines(final int countOfPlayer) {
		List<Line> result = new ArrayList<>();
		for (int i = 0; i < countOfPlayer - 1; i++) {
			result.add(Line.create(getPrevLine(result, i)));
		}
		this.lines = result;
	}

	private Line getPrevLine(final List<Line> result, final int i) {
		if(i == 0){
			return null;
		}
		return result.get(i - 1);
	}

	public int size(){
		return lines.size();
	}

	@Override
	public String toString() {
		return lines.stream()
			.map(Line::toString)
			.collect(Collectors.joining());
	}
}
