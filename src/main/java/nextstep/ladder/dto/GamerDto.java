package nextstep.ladder.dto;

import nextstep.ladder.domain.Gamer;

public class GamerDto {
    private final String name;
    private final int position;

    private GamerDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static GamerDto from(Gamer gamer) {
        return new GamerDto(gamer.getName(), gamer.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
