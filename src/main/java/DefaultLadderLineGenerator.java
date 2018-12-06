import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLadderLineGenerator implements LadderLineGenerator {
	private Positive height;

	private DefaultLadderLineGenerator() {
		throw new IllegalStateException();
	}

	public DefaultLadderLineGenerator(Positive height) {
		this.height = height;
	}

	@Override
	public boolean generatePoint() {
		return RANDOM.nextBoolean();
	}

	@Override
	public List<LadderLine> getLadderLines(int sizeOfPerson) {
		return IntStream.range(0, height.getValue())
				.mapToObj(i-> LadderLine.init(sizeOfPerson, this))
				.collect(Collectors.toList());
	}
}
