package step1.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import step1.domain.Ladder;
import step1.domain.UserNames;

public class LadderResultDto {

    private final List<LineDto> lineDtos = new ArrayList<>();
    private final List<String> userNames = new ArrayList<>();
    private final int height;

    public LadderResultDto(List<LineDto> lineDtos, List<String> userNames, int height) {
        this.lineDtos.addAll(lineDtos);
        this.userNames.addAll(userNames);
        this.height = height;
    }

    public static LadderResultDto from(Ladder ladder, UserNames userNames) {
        return new LadderResultDto(
            LineDto.from(ladder.getLines()),
            userNames.getPrimitiveUserNames(),
            ladder.getHeight()
        );
    }

    public List<String> getUserNames() {
        return userNames;
    }

    public int getHeight() {
        return height;
    }

    public List<LineDto> getLineDtos() {
        return lineDtos;
    }
}
