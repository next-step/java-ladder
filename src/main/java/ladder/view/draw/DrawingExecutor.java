package ladder.view.draw;

import static java.util.stream.Collectors.joining;

import java.util.stream.IntStream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Names;
import ladder.domain.line.LadderLine;
import ladder.domain.playing.Winnings;
import ladder.view.draw.shape.Shape;
import ladder.view.draw.shape.ShapeFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DrawingExecutor {

	public static void drawResult(LadderDrawingArgument argument) {
		String ladderDrawing = drawLadder(argument.getLadder());

		System.out.println(String.format("%s\n%s\n%s",
										 argument.getNames(),
										 ladderDrawing,
										 argument.getWinnings()));
	}

	public static void drawWinningResult(ResultDrawingArgument argument) {
		Winnings winnings = argument.getWinnings();
		Names names = argument.getNames();

		if (argument.getShowSize() == 1) {
			System.out.println(winnings);
			return;
		}
		System.out.println("실행결과\n" + IntStream.range(0, winnings.getSize())
											   .mapToObj(i -> names.getNameOf(i) + " : " + winnings.getWinningOf(i))
											   .collect(joining("\n")));
	}

	private static String drawLadder(Ladder ladder) {
		int height = ladder.getHeight();

		return IntStream.range(0, height)
						.mapToObj(i -> drawLine(ladder.getLine(i)))
						.collect(joining("\n"));
	}

	private static String drawLine(LadderLine line) {
		int width = line.getWidth();

		return IntStream.range(0, width)
						.mapToObj(i -> Shape.HEIGHT_CONNECTION + ShapeFactory.getBy(line)
																			 .getShape())
						.collect(joining());
	}

}
