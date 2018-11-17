package domain.dto;

import domain.Gamer;

/**
 * Created by hspark on 16/11/2018.
 */
public class GamerDTO {
	private int position;
	private String name;

	public static GamerDTO of(Gamer gamer) {
		GamerDTO gamerDTO = new GamerDTO();
		gamerDTO.setName(gamer.getName());
		gamerDTO.setPosition(gamer.getPosition());
		return gamerDTO;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setPosition(int position) {
		this.position = position;
	}

	public boolean isEqualName(String name) {
		return this.name.equals(name);
	}

	@Override
	public String toString() {
		return name;
	}
}
