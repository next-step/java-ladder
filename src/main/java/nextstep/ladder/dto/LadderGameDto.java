package nextstep.ladder.dto;

import java.util.List;

public class LadderGameDto {

    private List<UserDto> userDtos;
    private List<List<PointDto>> ladder;

    public LadderGameDto(List<UserDto> userDtos, List<List<PointDto>> ladder) {
        this.userDtos = userDtos;
        this.ladder = ladder;

    }

    public List<UserDto> getUserDtos() {
        return userDtos;
    }

    public List<List<PointDto>> getLadder() {
        return ladder;
    }

    public void setUserResult(int i, String result) {
        userDtos.get(i).setResult(result);
    }

    public String findResultByUserName(String name) {
        return userDtos.stream()
                .filter(o -> name.equals(o.getName()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("검색하신 이름이 없습니다"))
                .getResult();
    }

}
