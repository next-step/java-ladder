# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)


## 구현 목록
### 사다리 생성
- [ ] 입력받은 수 만큼의 층(Layer)을 생성한다.
- [x] Layer는 입력한 수 만큼의 선(Rung)을 갖는다.
- [x] 사다리를 생성한다.
- [x] 사다리의 계단을 생성한다.
- [x] 한층의 계단들의 집합인 Layer(사다리의 층) 일급컬렉션 생성
- [x] Rung 일급컬렉션 사용. 
- [x] Layer 계단 연속시 예외처리
- [x] 계단을 생성한다. (높이와 사용자 수)
- [x] 사용자를 , 형태로 입력받는다. 
- [x] Player(name, position) 생성 
- [x] Ladder Game을 생성한다. 
- [x] 사다리를 출력한다. 
- [ ] refactor : stream
- [x] players 내부 위임. 


