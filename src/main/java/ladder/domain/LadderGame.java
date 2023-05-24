package ladder.domain;

import ladder.dto.GameResultDto;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Users users;
    private final Ladder ladder;
    private final GameResult gameResult;

    public LadderGame(Users users, Ladder ladder, GameResult gameResult) {
        this.users = users;
        this.ladder = ladder;
        this.gameResult = gameResult;
    }

    public List<GameResultDto> execute() {
        List<GameResultDto> gameResultDtoList = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            int resultPosition = ladder.move(i);
            GameResultDto gameResultDto = new GameResultDto(users.getUserByIndex(i).name(), gameResult.getResultByIndex(resultPosition));

            gameResultDtoList.add(gameResultDto);
        }

        return gameResultDtoList;
    }

}
