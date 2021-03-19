package nextstep.ladder.entity;

import static nextstep.ladder.exception.UserExceptionMesssage.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.exception.UserException;

public class PrizeResult {
	private static final String DELIMETER = ",";
	private final List<Prize> prizes;

	public PrizeResult(List<Prize> prizes, int userSize) {
		validateUserSize(prizes.size(), userSize);
		this.prizes = prizes;
	}

	public PrizeResult(String result, int userSize) {
		this(Arrays.stream(result.split(DELIMETER))
				.map(Prize::new)
				.collect(Collectors.toList())
			, userSize);
	}

	private void validateUserSize(int size, int userSize) {
		if (userSize != size) {
			throw new UserException(NO_MATCH_PRIZE);
		}
	}

	public List<Prize> getPrizes() {
		return prizes;
	}

	@Override
	public String toString() {
		return this.prizes
			.stream()
			.map(Prize::toString)
			.collect(Collectors.joining());
	}
}
