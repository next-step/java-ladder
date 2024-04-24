package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Person;

import java.util.stream.Collectors;

public class Output {

    private static final String UNLINK = "    |";
    private static final String LINK = "----|";
    public void personName(Person persons) {
        print("사다리 결과");
        print(persons.name());
    }

    public void ladderResult(Ladder ladder) {
        ladder.getLadder().forEach(line -> {
            String result = line.getList().stream()
                    .map(isLink -> isLink ? LINK : UNLINK)
                    .collect(Collectors.joining());
            print(result);
        });
    }

    public void runResult(LadderResult results) {
        print(results.asString() + '\n');
    }

    private void print(String word) {
        System.out.println(word);
    }

    public void finalResult(Person person, LadderResult result, String want) {
        if (person.location(want) == -1) {
            for (int i = 0; i < result.size(); i++)
                print(person.get(i) + " : " + result.find(i));
        } else
            print(result.find(person.location(want)));
    }
}
