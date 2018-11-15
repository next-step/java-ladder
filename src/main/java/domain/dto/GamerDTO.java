package domain.dto;

import domain.Gamer;

/**
 * Created by hspark on 16/11/2018.
 */
public class GamerDTO {
	private String name;

	public static GamerDTO of(Gamer gamer) {
		GamerDTO gamerDTO = new GamerDTO();
		gamerDTO.setName(gamer.getName());
		return gamerDTO;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
