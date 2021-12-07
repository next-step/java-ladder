# 사다리 게임

## 사다리(생성) 생각해보기
* 이름, 사다리, 사다리게임
* 이름
  * 이름 값만 가지고 있으면 됨.
  * 유효성(최대 5글자)
  * 일급컬렉션인 이름s
* 사다리
  * 자료구조로써의 사다리, 2차원 boolean 배열 -> List<List<Boolean>> -> List<Line>
  * Line -> List<Line> -> List<LadderPart>
  * LadderPart -> Rail, Rung
  * 인덱스를 이용해 LadderPartFactory에서 Rail, Rung생성
  * 이전 Rung이 세팅되어있으면 다음 Rung은 빈 rung이어야 한다.
* Rail, Rung (LadderPart 구현체)
  * 짝수 Rail, 홀수 Rung
  * rail, rung, emptyRung
  * String value() -> "|", "-----", "     "


## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.





## 자바8 스트림, 람다, Optional 리뷰내용
* @FunctionalInterface 명시 굿
* Stream을 자주 사용하자
* 반환 타입에 따른 map 또는 mapToLong 꼼꼼히 보기
* Stream에서도 축약어는 쓰면 안된다. 앞으로 변수명에서 축약어 절대 금지
* 에러 메시지도 매직 스트링이다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)