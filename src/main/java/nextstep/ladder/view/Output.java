package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderReward;
import nextstep.ladder.domain.MatchingReward;
import nextstep.ladder.domain.Person;

import java.util.stream.Collectors;

public class Output {

    private static final String UNLINK = "    |";
    private static final String LINK = "----|";
    public void ladderResult(Person person, Ladder ladder, LadderReward result) {
        personName(person);
        ladderPrint(ladder);
        runReward(result);
    }
    private void personName(Person persons) {
        print("사다리 결과");
        print(persons.name());
    }

    private void ladderPrint(Ladder ladder) {
        ladder.getLadder().forEach(line -> {
            String result = line.getList().stream()
                    .map(isLink -> isLink ? LINK : UNLINK)
                    .collect(Collectors.joining());
            print(result);
        });
    }

    private void runReward(LadderReward results) {
        print(results.asString() + '\n');
    }

    private void print(String word) {
        System.out.println(word);
    }

    public void finalResult(MatchingReward match, String want) {
        print('\n' + "실행결과");
        if (want.equals("all")) {
            for (String key : match.getMatch().keySet()) {
                print(key + " : " + match.getMatch().get(key));
            }
        } else
            print(match.result(want));
    }
}
