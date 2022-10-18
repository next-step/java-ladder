package ladder.domain;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class LadderColumnWidth implements LadderColumn {

	private final boolean isNotEmpty;

	public LadderColumnWidth(boolean isNotEmpty) {
		this.isNotEmpty = isNotEmpty;
	}

	@Override
	public boolean isNotEmpty() {
		return isNotEmpty;
	}
}
