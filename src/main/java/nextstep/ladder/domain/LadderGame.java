package nextstep.ladder.domain;

import nextstep.ladder.dto.LadderGameResultDto;
import nextstep.ladder.dto.LadderRequestDto;
import nextstep.ladder.dto.LadderResultDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class LadderGame {
    private static final int ZERO = 0;

    private final List<Line> lines;
    private final List<Player> players;
    private final List<String> scores;

    public LadderGame(LadderRequestDto ladderRequestDto, MovementGenerator movementGenerator) {
        this.players = this.generatePlayers(ladderRequestDto.getNames());
        this.lines = this.generateLines(ladderRequestDto, movementGenerator);
        this.scores = ladderRequestDto.getScores();
    }

    private List<Line> generateLines(LadderRequestDto ladderRequestDto, MovementGenerator movementGenerator) {
        int countOfPerson = ladderRequestDto.getNames().size();
        return IntStream.range(ZERO, ladderRequestDto.getHeight())
                .mapToObj(currentHeight -> new Line(countOfPerson, movementGenerator))
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    private List<Player> generatePlayers(List<String> playerNames) {
        return playerNames.stream()
                .map(Player::new)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    public LadderResultDto getLadderResult() {
        return new LadderResultDto(this.players, this.lines, this.scores);
    }

    public List<LadderGameResultDto> execute() {
        List<LadderGameResultDto> ladderGameResultDtos = new ArrayList<>();
        int countOfPerson = this.players.size();
        for (int i = 0; i < countOfPerson; i++) {
            Player player = this.findPlayer(i);
            int moveIndex = this.moveLine(i);
            String score = this.findScore(moveIndex);
            LadderGameResultDto ladderGameResultDto = new LadderGameResultDto(player.getName(), score);
            ladderGameResultDtos.add(ladderGameResultDto);
        }

        return ladderGameResultDtos;
    }

    private int moveLine(int lineIndex) {
        int moveIndex = this.lines.get(ZERO).move(lineIndex);
        for (int i = 1; i < this.lines.size(); i++) {
            moveIndex = lines.get(i).move(moveIndex);
        }
        return moveIndex;
    }

    private Player findPlayer(int index) {
        return this.players.get(index);
    }

    private String findScore(int index) {
        return this.scores.get(index);
    }
}
