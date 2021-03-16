package nextstep.ladder.entity;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
	private final List<Root> roots;

	public Line(int countOfPerson) {

		List<Root> initials = makeRoots((i) -> new Root(new RandomMakeRootStrategy()), countOfPerson);
		this.roots = makeRoots(makeRootWithInitialRandomRoots.apply(initials), countOfPerson);
	}

	public List<Root> getRoots() {
		return roots;
	}

	private List<Root> makeRoots(IntFunction<Root> function, int countOfPerson) {
		return IntStream.range(0, countOfPerson - 1)
			.mapToObj(function)
			.collect(Collectors.toList());
	}

	private Function<List<Root>, IntFunction<Root>> makeRootWithInitialRandomRoots = (initials) -> (i) -> {
		if (i > 0 && initials.get(i - 1).getRoot()) {
			return new Root(() -> false);
		}
		return initials.get(i);
	};

	@Override
	public String toString() {
		return "|" + this.roots.stream()
			.map(Root::toString)
			.collect(Collectors.joining("|")) +
			"|";
	}
}
