package domain;

import com.google.common.base.Preconditions;

/**
 * Created by hspark on 16/11/2018.
 */
public class Gamer {
	public static final int MAX_GAMER_NAME_LENGTH = 5;
	private String name;

	public Gamer(String name) {
		Preconditions.checkArgument(name.length() <= 5, "이름이 너무 깁니다.");
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
