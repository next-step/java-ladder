package nextstep.ladder.dto;

public class LadderRequestDto {
    private String names;
    private int height;
    private String results;

    public LadderRequestDto(String names, int height, String results) {
        this.names = names;
        this.height = height;
        this.results = results;
    }

    public String getNames() {
        return names;
    }

    public int getHeight() {
        return height;
    }

    public String getResults() {
        return results;
    }
}
