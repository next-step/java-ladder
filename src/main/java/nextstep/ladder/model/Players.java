package nextstep.ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Name> names;
    private List<Prize> prizes;

    public Players(String continuousName, String continuousPrize) {
        this.names = splitPlayerName(continuousName);
        this.prizes = splitPrizeName(continuousPrize);
    }

    private List<Name> splitPlayerName(String continuousName) {
        String[] names = continuousName.replace(" ", "").split(",");
        return Arrays.stream(names)
                .peek(name -> {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException("각 이름은 다섯 글자 내로 입력해주세요.");
                    }
                })
                .map(name -> new Name(name))
                .collect(Collectors.toList());
    }

    private List<Prize> splitPrizeName(String continuousPrize) {
        String[] prizes = continuousPrize.replace(" ", "").split(",");
        return Arrays.stream(prizes)
                .peek(prize -> {
                    if (prize.length() > 5) {
                        throw new IllegalArgumentException("각 결과는 다섯 글자 내로 입력해주세요.");
                    }
                })
                .map(prize -> new Prize(prize))
                .collect(Collectors.toList());
    }

    public String getFormattedName() {
        return this.names.stream()
                .map(name -> name.getNameFormatted())
                .collect(Collectors.joining());
    }

    public String getFormattedPrize() {
        return this.prizes.stream()
                .map(prize -> prize.getNameFormatted())
                .collect(Collectors.joining());
    }

    public int getPosition(String playerName) {
        return names.stream()
                .filter(name -> name.isEquals(playerName))
                .mapToInt(name -> names.indexOf(name))
                .boxed()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("이름이 일치하는 사람이 없습니다."));
    }

    public int countOfPlayer() {
        return names.size();
    }

    public String getName(int position) {
        return names.get(position).getName();
    }

    public String getPrize(int position) {
        return prizes.get(position).getPrize();
    }
}
