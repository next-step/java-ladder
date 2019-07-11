package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {
    private static Random random = new Random();

    public static Ladder generateLadder(int height, Players players) {
        return new Ladder(IntStream.range(0, height)
                .mapToObj(x -> generateLine(players))
                .collect(Collectors.toList()));
    }
    
    public static Ladder2 generateLadder2(int height, Players players) {
        return new Ladder2(IntStream.range(0, height)
                .mapToObj(x -> LadderLine.init(players))
                .collect(Collectors.toList()));
    }

	public static Line generateLine(Players players) {
		List<Boolean> points = new ArrayList<>();
		points.add(random.nextBoolean());
		for (int i = 1; i < players.size() - 1; i++) {
			points.add(checkFrontLine(points.get(i - 1)));
		}
		return new Line(points);
	}

	private static boolean checkFrontLine(boolean point) {
		return point ? false : random.nextBoolean();
	}
    
}
