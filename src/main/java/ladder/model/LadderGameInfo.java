package ladder.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameInfo {

  private final List<Name> participants;
  private final List<String> results;

  public LadderGameInfo(String participants, String results) {
    this(convertStringToNameList(participants), convertStringToStringList(results));
  }

  public LadderGameInfo(List<Name> participants, List<String> results) {
    validateParticipantsAndResults(participants, results);
    this.participants = participants;
    this.results = results;
  }

  public int getParticipantCnt() {
    return participants.size();
  }

  public int getParticipantPositionByName(String name){
    return participants.indexOf((new Name(name)));
  }

  public String getResultByPosition(int position){
    return results.get(position);
  }

  public List<String> getParticipantNames() {
    return participants.stream().map(Name::getValue).collect(Collectors.toList());
  }

  public List<String> getResults() {
    return Collections.unmodifiableList(results);
  }

  private static List<String> convertStringToStringList(String str) {
    return Arrays.stream(str.split(","))
        .map(String::trim)
        .collect(Collectors.toList());
  }

  private static List<Name> convertStringToNameList(String str) {
    return Arrays.stream(str.split(","))
        .map(String::trim)
        .map(Name::new)
        .collect(Collectors.toList());
  }

  private void validateParticipantsAndResults(List<Name> participants, List<String> results) {
    if (participants.stream().distinct().count() != participants.size()){
      throw new IllegalArgumentException("중복된 이름은 허용하지 않습니다.");
    }
    if(participants.size() != results.size()){
      throw new IllegalArgumentException("참여할 인원과 실행결과의 개수는 같아야합니다.");
    }
  }
}
