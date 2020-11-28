# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 2단계 - 사다리(생성)
### 기능 요구사항
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
- |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

### 프로그래밍 요구사항
- 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
- 규칙 6: 모든 엔티티를 작게 유지한다.

Q) 기본타입을 포장한 래핑클래스의 value가 불변원시타입이라면 getter없이 public으로 노출시키는건 어떤가요? 예를들어 지금 Height의 value는 public 한 필드로 노출시켰습니다.

### 2단계 피드백 사항
- [x] 메소드는 동사형으로 시작되어야 합니다~! (ApplicationExecutor)
- [x] 래핑된 value의 getter()
- [x] names 를 만드는 부분도 메소드로 분리해보면 좋을 것 같아요!
- [x] View 에서 사용되는 문자열도 별도 상수로 관리되면 좋을 것 같아요!
- [x] Ladder 는 모델 계층에 속해있으므로 View 와 관련된 로직은 분리되어야 하지 않을까요~?

## 3단계 - 사다리(게임 실행)
### 기능 요구사항
- 사다리 실행 결과를 출력해야 한다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

### 프로그래밍 요구사항
- 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
- 규칙 6: 모든 엔티티를 작게 유지한다.
- 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

### 3단계 피드백 사항
- [x] 파라미터 이름으로 축약어 사용은 최대한 지양하는 것이 어떨까요~? (getNextIndexOf(int currIndex))
- [x] NumberOfParticipants 값을 넘겨주는 것은 어떨까요~? (private Results(List<String> value, Participants participants) {)
    - 그러네요. 굳이 필요없는 도메인에게 의존성을 갖게 되는 문제가 있었군요! :)
- [ ] Results 라는 이름은 ExecutionResults 의 상위 개념으로 오해할 수 도 있을 것 같아요.
- [ ] allKeyword 에 대한 판단을 view 에서 했을때와 view 외부에서 계층에서 했을 때의 각각의 장단점은 무엇일까요~?