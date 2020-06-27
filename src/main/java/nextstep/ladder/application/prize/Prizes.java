package nextstep.ladder.application.prize;

import java.util.Collections;
import java.util.List;

public class Prizes {
	private final List<Prize> prizes;

	private Prizes(List<Prize> prizes) {
		this.prizes = prizes;
	}

	public static Prizes ofPrizes(List<Prize> prizes) {
		return new Prizes(prizes);
	}

	public List<Prize> getPrizes() {
		return Collections.unmodifiableList(prizes);
	}

	public String printPrizes() {
		StringBuilder builder = new StringBuilder();
		prizes.forEach(prize ->
			builder.append(String.format("%-6s", prize.getName()))
		);
		return builder.toString();
	}

	public int prizeIndex(Prize prize) {
		return prizes.indexOf(prize);
	}
}
