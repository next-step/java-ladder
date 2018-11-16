package laddergame.domain;

import java.util.List;

public class Line {

	private static final String VERTICAL_CHARACTER = "|";
	private static final String HORIZON_CHARACTER = "-";
	private static final String EMPTY_CHARACTER = " ";

	private List<Boolean> points;

	public Line(int playerCount) {
		this(RandomLineGenerator.generate(playerCount));
	}

	public Line(List<Boolean> points) {
		this.points = points;
	}

	public String draw() {
		StringBuilder line = new StringBuilder();
		for (Boolean point : points) {
			line.append(getLineCharacters(point)).append(VERTICAL_CHARACTER);
		}
		return line.toString();
	}

	private String getLineCharacters(Boolean point) {
		StringBuilder lineCharacters = new StringBuilder();
		String lineCharacter = (point)? HORIZON_CHARACTER : EMPTY_CHARACTER;
		for (int count = 0; count < Player.MAX_NAME_LENGTH; count++) {
			lineCharacters.append(lineCharacter);
		}
		return lineCharacters.toString();
	}

	/**
	 * 현재 인덱스의 좌표에 선이 있는지 확인 (마지막 좌표인 경우는 왼쪽만 체크)
	 * 선이 없다면 좌표점을 기준으로 왼쪽으로 선이 그려지기 때문에 오른쪽을 체크
	 * @param index
	 * @return
	 */
	public int move(int index) {
		Boolean point = points.get(index);
		if(point) {
			return index - 1;
		}
		if(isLastIndex(index)) {
			return index;
		}
		return findNextIndex(index);
	}

	private boolean isLastIndex(int index) {
		return index == points.size() - 1;
	}

	private int findNextIndex(int index) {
		int nextIndex = index + 1;
		Boolean point = points.get(nextIndex);
		if(point) {
			return nextIndex;
		}
		return index;
	}
}
