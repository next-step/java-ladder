package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
	public static final String NOT_ENOUGH_PERSON = "참여자의 숫자가 부족합니다.";
	public static final int MINIMUM_COUNT = 2;

	private List<Block> blocks = new ArrayList<>();

	public Line(int countOfPerson) {
		validate(countOfPerson);
		createBlocks(countOfPerson);
	}

	private void validate(int countOfPerson) {
		if (countOfPerson < MINIMUM_COUNT) {
			throw new IllegalArgumentException(NOT_ENOUGH_PERSON);
		}
	}

	private void createBlocks(int count) {
		IntStream.range(0, count).forEach(number -> add());
	}

	private void add() {
		if (this.blocks.isEmpty()) {
			this.blocks.add(new Block(false));
			return;
		}

		Block currentBlock = blocks.get(blocks.size() - 1);
		blocks.add(currentBlock.makeNext(Utils.makeRandomBoolean()));
	}

	public List<Block> blocks() {
		return this.blocks;
	}
}
