## Todo
- [ ] 개행문자 하드코딩된 부분들을 System.lineSeparator() 메서드 사용해서 변경

## Done
- [X] 참여자가 ""일 경우에 예외("" => IllegalArgumentException) 
- [X] 전체 참여자가 1명 이하일 경우에 예외("pobi" => IllegalArugmentExcepiton)
- [X] 참여자들은 ','를 구분자로 구분("pobi,honux" => pobi, honux)
- [X] 최대 사다리 높이는 0이하이면 예외(0 => IllegalArgumentException)
- [X] 하나의 라인은 (참여자들 -1)개만큼의 boolean 값들이 존재(5 => true,true,false,ture, 3 => true,false)
- [X] 라인들은 사다리 높이 개만큼 존재(5 => 5)
- [X] 출력("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)")
- [X] 이름 입력("pobi,houx")
- [X] 출력("최대 사다리 높이는 몇 개인가요?")
- [X] 높이 입력(5)
- [X] 출력("실행결과")
- [X] 사다리 출력
- [X] Participant가 참여자들이 아닌 각각의 참여자를 의미하도록 변경
- [X] 참여자들을 관리하는 Participants 추가
- [X] Name null checking 추가
- [X] Point 생성에 대한 책임을 Participant가 아닌 Line으로 이동
- [X] Line 생성에 대한 책임을 Height가 아닌 Lines로 이동
