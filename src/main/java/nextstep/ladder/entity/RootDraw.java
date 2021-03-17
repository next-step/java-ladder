package nextstep.ladder.entity;

import java.util.Arrays;

public enum RootDraw {
	TRUE(true, "-"),
	FALSE(false, " ");
	private final boolean checkRoot;
	private final String str;


	RootDraw(boolean checkRoot, String str) {
		this.checkRoot = checkRoot;
		this.str = str;
	}

	public static RootDraw getInstance(boolean isValid) {
		return Arrays.stream(values())
			.filter(draw -> isValid == draw.checkRoot)
			.findFirst()
			.get();
	}

	public String getStr() {
		return str;
	}
}
