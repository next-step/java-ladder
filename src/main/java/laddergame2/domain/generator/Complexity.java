package laddergame2.domain.generator;

import java.util.Arrays;

public enum Complexity {

	HIGH("상", 20, 80),
	MEDIUM("중", 15, 60),
	LOW("하", 5, 40);

	private String name;
	private int ladderHeight;
	private int lineGenerationPercent;

	Complexity(String name, int ladderHeight, int lineGenerationPercent) {
		this.name = name;
		this.ladderHeight = ladderHeight;
		this.lineGenerationPercent = lineGenerationPercent;
	}

	public static Complexity from(String name) {
		return Arrays.stream(Complexity.values())
				.filter(complexity -> complexity.name.equals(name))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 복잡도입니다."));
	}

	public boolean canGenerate(double randomPercent) {
		return randomPercent <= lineGenerationPercent;
	}

	public int getLadderHeight() {
		return ladderHeight;
	}
}
