package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final Lines lines;
    private final Users users;

    public static Ladder of(int floor, List<String> users, List<String> ladderGameWinningProduct, LineStrategy strategy) {
        return new Ladder(
                Floor.from(floor),
                users,
                ladderGameWinningProduct,
                strategy
        );
    }

    private Ladder(Floor floor, List<String> users, List<String> ladderGameWinningProduct, LineStrategy strategy) {
        validate(users, ladderGameWinningProduct);

        this.lines = Lines.of(floor, users.size(), strategy);

        List<Integer> gameResult = this.lines.gameResult(users.size());
        List<String> mappedWinningProducts = gameResult.stream()
                .map(ladderGameWinningProduct::get)
                .collect(Collectors.toList());

        this.users = Users.from(users, mappedWinningProducts);
    }

    private void validate(List<String> users, List<String> ladderGameWinningProduct) {
        if (users.size() != ladderGameWinningProduct.size()) {
            throw new IllegalArgumentException("상품 개수와 우승 상품 개수가 상이합니다.");
        }
    }

    public List<String> getParticipants() {
        return this.users.toNameList();
    }

    public String getUserProducts(String name) {
        return this.users.getWinningProductOf(name);
    }

    public List<Line> getLadderInfo() {
        return this.lines.toList();
    }
}
