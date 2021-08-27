package nextstep.ladder.dto;

public class PlayerDto {

    private final String name;
    private final int maxLength;

    public PlayerDto(final String name, final int maxLength) {
        this.name = name;
        this.maxLength = maxLength;
    }

    public String getName() {
        return name;
    }

    public int getMaxLength() {
        return maxLength;
    }
}
