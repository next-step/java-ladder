package ladder.domain;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class LadderColumnWidth implements LadderColumn {

	private final boolean isEmpty;

	public LadderColumnWidth(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	@Override
	public boolean isNotEmpty() {
		return isEmpty;
	}
}
