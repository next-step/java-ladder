package nextstep.ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> names;

    public Players(String continuousName) {
        this.names = splitName(continuousName);
    }

    private List<Player> splitName(String continuousName) {
        String[] names = continuousName.replace(" ", "").split(",");
        return Arrays.stream(names)
                .peek(name -> {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException("각 이름은 다섯 글자 내로 입력해주세요.");
                    }
                })
                .map(name -> new Player(name))
                .collect(Collectors.toList());
    }

    public int countOfPlayer() {
        return names.size();
    }

    public int getPosition(String playerName) {
        // 플레이어 찾아서 indexof에 넣기
        return names.stream()
                .filter(name -> name.isEquals(playerName))
                .mapToInt(name -> names.indexOf(name))
                .boxed()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("이름이 일치하는 사람이 없습니다."));
    }

    public String getFormattedName() {
        return this.names.stream()
                .map(name -> name.getNameFormatted())
                .collect(Collectors.joining());
    }

    public String getName(int position) {
        return names.get(position).getName();
    }

    public List<Player> getNames() {
        return names;
    }
}
