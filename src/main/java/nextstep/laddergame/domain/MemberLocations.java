package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemberLocations {

  private List<MemberLocation> memberLocations;

  public MemberLocations(List<MemberLocation> memberLocations) {
    this.memberLocations = memberLocations;
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

  public Map<Member, Prize> createResultMap(Prizes prizes) {
    return memberLocations.stream()
        .collect(Collectors
            .toMap(location -> location.getMember(), location -> location.getPrize(prizes)));
  }

  public List<MemberLocation> getMemberLocations() {
    return Collections.unmodifiableList(memberLocations);
  }
}
