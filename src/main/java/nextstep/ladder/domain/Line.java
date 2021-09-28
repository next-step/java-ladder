package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
	public static final String NOT_ENOUGH_PERSON = "참여자의 숫자가 부족합니다.";
	public static final int MINIMUM_COUNT = 2;
	public static final int INITIAL_POSITION = 1;

	private List<Block> blocks = new ArrayList<>();

	public Line(int countOfPerson) {
		validate(countOfPerson);
		createBlocks(countOfPerson);
	}

	public void play(Participant participant) {
		blocks
			.stream()
			.filter(block -> participant.match(block.position()))
			.findFirst()
			.get()
			.enter(participant);
	}

	private void validate(int countOfPerson) {
		if (countOfPerson < MINIMUM_COUNT) {
			throw new IllegalArgumentException(NOT_ENOUGH_PERSON);
		}
	}

	private void createBlocks(int count) {
		IntStream.range(0, count).forEach(number -> this.blocks.add(createBlock(count)));
	}

	private Block createBlock(int maximumBlockSize) {
		if (this.blocks.isEmpty()) {
			return new Block(LadderDirectionGenerator.makeRightOrNothing(), new Position(INITIAL_POSITION));
		}

		Block currentBlock = blocks.get(blocks.size() - 1);

		if (this.blocks.size() == maximumBlockSize - 1) {
			return currentBlock.makeNext(Direction.NOTHING);
		}

		return currentBlock.makeNext(LadderDirectionGenerator.makeRightOrNothing());

	}

	public List<Block> blocks() {
		return this.blocks;
	}
}
