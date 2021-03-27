### 커밋 로그 해설
> 프로젝트 진행 과정을 한 눈에 확인하기 위해 제작. 자세한 내용은 실제 커밋에 나와있습니다.
```html
feat(step2): generate controller
메인 클래스와 컨트롤러를 생성

feat(step2): add participants input view
인풋 뷰, 서비스, Exception 클래스 생성
이름을 받아서 검증

refact(step2): move service logic to domain
participant 도메인으로 이름 검증 로직 이동
participantList 일급 컬렉션을 통해 팩토리 패턴으로 participant 리스트 생성

feat(step2): add maximum ladder height input view
사다리 높이를 인풋으로 받음
인풋은 서비스로 전달되고 도메인을 통해 검증됨

feat(step2): add base ladder map
사다리의 위치 정보를 초기화
사다리 세로줄을 완성
사다리 맵 상단에 이름 추가

feat(step2): add horizontal link on ladder map
사다리의 가로줄을 랜덤으로 추가
결과 출력 화면 추가
```
