package nextstep.laddergame.nextstep;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.laddergame.engine.Member;
import nextstep.laddergame.engine.Members;
import nextstep.laddergame.engine.Point;
import nextstep.laddergame.engine.Prize;
import nextstep.laddergame.engine.Prizes;
import nextstep.laddergame.engine.Row;

public class MemberLocations {

  private final List<MemberLocation> memberLocations;

  public MemberLocations(List<MemberLocation> memberLocations) {
    this.memberLocations = memberLocations;
  }

  public static MemberLocations createStartLocation(Members members) {
    List<MemberLocation> memberLocations = IntStream.range(0, members.getSize())
        .mapToObj(i -> new MemberLocation(members.getMember(i), i))
        .collect(Collectors.toList());

    return new MemberLocations(memberLocations);
  }

  public MemberLocations goNextStep(Row row) {
    List<MemberLocation> memberLocations = this.memberLocations.stream()
        .map(location -> {
          Point point = location.getPoint(row);
          return location.goNextStep(point);
        })
        .collect(Collectors.toList());

    return new MemberLocations(memberLocations);
  }

  public Map<Member, Prize> createGameResult(Prizes prizes) {
    return memberLocations.stream()
        .collect(Collectors
            .toMap(location -> location.getMember(), location -> location.getPrize(prizes)));
  }
}
