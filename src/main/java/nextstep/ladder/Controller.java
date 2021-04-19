package nextstep.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.PrizeMapper;
import nextstep.ladder.domain.Prizes;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Controller {
    public void run() {
        List<String> info = InputView.getInfoFromClient();

        Players players = new Players(Arrays.asList(info.get(0).split(",")));
        Prizes prizes = new Prizes(Arrays.asList(info.get(1).split(",")));
        PrizeMapper prizeMapper = new PrizeMapper(prizes, players);
        LadderGame game = new LadderGame(prizeMapper, Integer.parseInt(info.get(2)));

        ResultView.printObjectsName(players.getAllPlayerNames());
        ResultView.printLadderResult(game.build(), players.getPlayerCount());

        ResultView.printObjectsName(prizes.getAllPrizesName());

        String input = InputView.getPlayerResult();
        if ("all".equals(input)) {
            ResultView.printResultList(mapperToStringDto(game.start()));
            return;
        }
        ResultView.printResultList(Arrays.asList(game.start().get(players.findPlayerByName(input)).toString()));
    }

    private List<String> mapperToStringDto(Map<?, ?> mapper) {
        List<String> keys = mapper.keySet().stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        List<String> values = mapper.values().stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        List<String> combined = new ArrayList<>();

        IntStream.range(0, mapper.size())
                .forEach(i -> combined.add(keys.get(i) + " : " + values.get(i)));
        return combined;
    }
}
