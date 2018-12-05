import java.util.List;
import java.util.Random;

public interface LadderLineGenerator {
	public static final Random RANDOM = new Random();
	public static boolean generatePoint() {
		return RANDOM.nextBoolean();
	}
	public List<LadderLine> getLadderLines(Positive height, int sizeOfPerson);
}
