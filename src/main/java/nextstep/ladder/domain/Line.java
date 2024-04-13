package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
	private final List<Bridge> bridges = new ArrayList<>();

	public Line(final Generator generator, final int numberOfPeople) {
		while (bridges.size() < numberOfPeople - 1){
			final boolean now = generator.generate();
			addBridge(Bridge.from(now));

		}
	}

	private void addBridge(final Bridge now) {
		if (bridges.isEmpty()) {
			bridges.add(now);
			return;
		}
		if (bridges.get(bridges.size() - 1).isBridge()) {
			bridges.add(Bridge.from(false));
			return;
		}
		bridges.add(now);
	}

	public List<Bridge> getBridges() {
		return bridges;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Line line = (Line)o;
		return Objects.equals(bridges, line.bridges);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bridges);
	}
}
