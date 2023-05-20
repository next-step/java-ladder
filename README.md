# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
### LineStrategy
- [X] true 혹은 false 중 하나를 가진다.

### LadderRow
- [X] 주어진 width만큼의 line 생성 여부를 LineStrategy에 따라 결정한다.
- [X] 단, 연달아 line을 생성하지 않는다. 

### Ladder
- [X] 주어진 height만큼의 Row 리스트를 가진다.

### Player
- [ ] 5자 이내의 이름을 가진다.

### Players
- [ ] Player 리스트를 가진다.