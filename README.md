# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

---
## 🚀 2단계 - 사다리(생성)
### 기능 요구사항
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
- |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

### Todo
- [X] 사용자로부터 참여하는 사람의 이름을 입력받는다.
- [X] 이름은 쉼표(,)로 구분한다.
- [X] 사람 이름은 최대 5자까지 가능하다.
- [X] 사용자로부터 사다리의 최대 높이를 입력받는다.
- [X] 사다리를 생성한다.
  - [X] 가로 라인이 겹치지 않아야 한다.
- [X] 생성한 사다리를 이름과 함께 출력한다.

---
## 🚀 3단계 - 사다리(게임 실행)
### 기능 요구사항
- 사다리 실행 결과를 출력해야 한다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

### Todo
- [X] 사용자로부터 실행결과를 입력받는다.
- [X] 사다리 생성 후에 실행결과를 출력한다.
- [ ] 사용자로부터 결과 조회할 사람을 입력받는다.
- [ ] 입력받는 사람의 게임 결과를 출력한다.
- [ ] all 입력 시 모든 사람의 게임 결과를 출력한다.
