package ladder.view.draw.shape;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.NoArgsConstructor;

import ladder.domain.line.Line;

@NoArgsConstructor
public class ShapeFactory {
	private static final Shape WIDTH_CONNECTION_DRAW_SHAPE = () -> IntStream.range(0, Shape.WIDTH_LINE_COUNT)
																			.mapToObj(i -> Shape.WIDTH_CONNECTION)
																			.collect(Collectors.joining());
	private static final Shape WIDTH_WHITE_SPACE_DRAW_SHAPE = () -> IntStream.range(0, Shape.WIDTH_LINE_COUNT)
																			 .mapToObj(i -> Shape.WIDTH_WHITE_SPACE)
																			 .collect(Collectors.joining());
	private static final Shape NEW_LINE_DRAW_SHAPE = () -> Shape.NEW_LINE;

	public static Shape getBy(Line line) {
		if (!line.hasNext()) {
			return NEW_LINE_DRAW_SHAPE;
		}

		return line.next() ? WIDTH_CONNECTION_DRAW_SHAPE : WIDTH_WHITE_SPACE_DRAW_SHAPE;
	}
}
