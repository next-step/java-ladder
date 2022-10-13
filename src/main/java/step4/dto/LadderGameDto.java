package step4.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import step4.domain.Ladder;
import step4.domain.Prize;
import step4.domain.UserName;
import step4.domain.UserNames;

public class LadderGameDto {

    private final List<LineDto> lineDtos = new ArrayList<>();
    private final List<String> userNames = new ArrayList<>();
    private final List<String> prizes = new ArrayList<>();
    private final int height;

    public LadderGameDto(List<LineDto> lineDtos, List<String> userNames, List<String> prizes, int height) {
        this.lineDtos.addAll(lineDtos);
        this.userNames.addAll(userNames);
        this.prizes.addAll(prizes);
        this.height = height;
    }

    public static LadderGameDto from(Ladder ladder, UserNames userNames, List<Prize> prizes) {
        return new LadderGameDto(
            LineDto.from(ladder.getLines()),
            userNames.getUserNames().stream()
                .map(UserName::getUserName)
                .collect(Collectors.toList()),
            prizes.stream().map(Prize::getPrize).collect(Collectors.toList()),
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

    public List<String> getPrizes() {
        return prizes;
    }
}
