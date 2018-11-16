package domain.dto;

import domain.LadderLine;

/**
 * Created by hspark on 16/11/2018.
 */
public final class LineDTO {
	private boolean drawn;

	public static LineDTO of(LadderLine ladderLine) {
		LineDTO lineDTO = new LineDTO();
		lineDTO.setDrawn(ladderLine.isDrawn());
		return lineDTO;
	}

	private void setDrawn(boolean drawn) {
		this.drawn = drawn;
	}

	public boolean isDrawn() {
		return drawn;
	}
}
