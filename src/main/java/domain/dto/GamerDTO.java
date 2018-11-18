package domain.dto;

import domain.Gamer;
import domain.Point;

/**
 * Created by hspark on 16/11/2018.
 */
public class GamerDTO {
	private Point point;
	private String name;

	public static GamerDTO of(Gamer gamer) {
		GamerDTO gamerDTO = new GamerDTO();
		gamerDTO.setName(gamer.getName());
		gamerDTO.setPoint(gamer.getPoint());
		return gamerDTO;
	}

	public String getName() {
		return name;
	}

	public Point getPoint() {
		return point;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setPoint(Point point) {
		this.point = point;
	}

	public boolean isEqualName(String name) {
		return this.name.equals(name);
	}

	@Override
	public String toString() {
		return name;
	}
}
