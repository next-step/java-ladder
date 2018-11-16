package domain.dto;

import java.util.List;

/**
 * Created by hspark on 16/11/2018.
 */
public class LadderLayerDTO {
	private List<LineDTO> lineDTOList;

	public LadderLayerDTO(List<LineDTO> lineDTOList) {
		this.lineDTOList = lineDTOList;
	}

	public List<LineDTO> getLineDTOList() {
		return lineDTOList;
	}
}
