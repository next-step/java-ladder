import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLadderLineGen implements LadderLineGen {
	
	@Override
	public List<LadderLine> getLadderLines(Positive height, int sizeOfPerson) {
		return IntStream.range(0, height.getValue())
				.mapToObj(i-> LadderLine.init(sizeOfPerson))
				.collect(Collectors.toList());
	}
}
