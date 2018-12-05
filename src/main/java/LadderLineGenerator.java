import java.util.List;
import java.util.Random;

public interface LadderLineGenerator {
	public static final Random RANDOM = new Random();
	public boolean generatePoint();
	public List<LadderLine> getLadderLines(int sizeOfPerson);
}
