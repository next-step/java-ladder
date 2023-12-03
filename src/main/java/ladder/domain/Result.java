package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Result {

    private final List<String> results;

    public Result(List<String> results) {
        if (results.stream().anyMatch(r -> r.length() > 5) || results.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("결과는 1 ~ 5 자로 입력하세요.");
        }
        this.results = results;
    }

    public Result(String[] resultData, String[] personData) {
        if (Arrays.stream(resultData).count() != Arrays.stream(personData).count()) {
            throw new IllegalArgumentException("참가자 숫자와 동일한 결과를 입력하세요.");
        }
        if (Arrays.stream(resultData).anyMatch(r -> r.length() > 5) ||
                Arrays.stream(resultData).anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("결과는 1 ~ 5 자로 입력하세요.");
        }
        this.results = Arrays.stream(resultData).collect(Collectors.toList());
    }

    public List<String> getResults() {
        return results;
    }

    public List<String> findResult(Game game, String name) {
        if (name.equals("all")) {
            return game.getPersons().getPersonList().stream()
                    .map(p -> p.getName() + " : " + results.get(p.getPosition()))
                    .collect(Collectors.toList());
        }

        Optional<Integer> findResult = game.getPersons().getPersonList().stream()
                .filter(p -> p.getName().equals(name))
                .map(Person::getPosition)
                .findAny();

        if (findResult.isEmpty()) {
            return Collections.singletonList("일치하는 이름이 없습니다.");
        }

        return Collections.singletonList(results.get(findResult.get()));
    }

    public String formattedResults() {
        return results.stream()
                .map(r -> String.format("%6s", r))
                .reduce((r1, r2) -> r1 + r2)
                .get();
    }
}
