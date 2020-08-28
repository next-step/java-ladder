package ladder.view.draw;

import static java.util.stream.Collectors.joining;

import java.util.stream.IntStream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;
import ladder.view.draw.shape.Shape;
import ladder.view.draw.shape.ShapeFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DrawingExecutor {

	public static void drawResult(DrawArgument argument) {
		String ladderDrawing = drawLadder(argument.getLadder());

		System.out.println(String.format("%s\n%s", argument.getNames(), ladderDrawing));
	}


	private static String drawLadder(Ladder ladder) {
		int height = ladder.getHeight();

		return IntStream.range(0, height)
						.mapToObj(i -> drawLine(ladder.getLine(i)))
						.collect(joining());
	}

	private static String drawLine(Line line) {
		int width = line.getWidth();

		return IntStream.range(0, width)
						.mapToObj(i -> Shape.HEIGHT_CONNECTION + ShapeFactory.getBy(line)
																			 .getShape())
						.collect(joining());
	}

}
