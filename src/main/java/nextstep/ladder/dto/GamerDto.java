package nextstep.ladder.dto;

public class GamerDto {
    private final String name;
    private final int position;

    private GamerDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static GamerDto of(String name, int position) {
        return new GamerDto(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
