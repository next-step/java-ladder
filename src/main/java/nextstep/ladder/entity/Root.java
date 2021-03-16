package nextstep.ladder.entity;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Root {
	private final boolean root;

	Root(RootMakeStrategy strategy) {
		this.root = strategy.hasRoot();
	}
	public boolean getRoot() {
		return this.root;
	}

	@Override
	public String toString() {
		return IntStream.range(0, 5)
			.mapToObj((i) -> RootDraw.getInstance(root))
			.map(RootDraw::getStr)
			.collect(Collectors.joining(""));
	}
}
