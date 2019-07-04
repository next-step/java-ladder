package ladder.view.out;

import ladder.domain.Ladder;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderViewer {


	private static final String EMPTY_SYMBOL = " ";

	private static final String STEP_SYMBOL = "-";

	private static final String RAIL_SYMBOL = "|";

	private final String nameFormat;

	private final String railWithStep;

	private final String railWithoutStep;

	private final MessagePrinter printer;

	public LadderViewer(MessagePrinter printer, int stepWidth){
		this.printer = printer;

		// 사다리 가로스텝 넓이값을 기준으로 생성
		this.nameFormat = "%" + (stepWidth + 1) + "s"; // if stepWidth 5 then %6s, add rail width
		this.railWithStep = this.repeatSymbol(STEP_SYMBOL, stepWidth) + RAIL_SYMBOL;
		this.railWithoutStep = this.repeatSymbol(EMPTY_SYMBOL, stepWidth) + RAIL_SYMBOL;
	}

	private String repeatSymbol(String symbol, int count) {
		String[] array = new String[count];
		Arrays.fill(array, symbol);
		return String.join("", array);
	}

	public void render(Stream<String> playerNames, Ladder ladder){

		String names = playerNames.map(name -> String.format(nameFormat, name))
				.collect(Collectors.joining());

		printer.print(names);

		ladder.getRows().forEach(row -> {
			String rendered = row.getStepsAsStream()
					.map(step -> step ? railWithStep : railWithoutStep)
					.collect(Collectors.joining());
			printer.print(rendered);
		});
	}
}
