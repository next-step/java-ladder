package ladder.domain;

import ladder.dto.InputDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class LadderFactory {

	private LadderFactory() {
	}

	public static Ladder create(InputDTO inputDTO) {
		List<LadderRow> ladderRows = new ArrayList<>();

		for (int i = 0; i < inputDTO.getHeight(); i++) {
			ladderRows.add(new LadderRow(inputDTO.getPersons().size()));
		}

		return new Ladder(ladderRows);
	}
}
