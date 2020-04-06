package nextstep.ladder.dto;

public class LadderRequestDto {
    private String names;
    private int height;

    public LadderRequestDto(String names, int height) {
        this.names = names;
        this.height = height;
    }

    public String getNames() {
        return names;
    }

    public int getHeight() {
        return height;
    }
}
