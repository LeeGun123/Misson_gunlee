### 1. 프로젝트 소개
프로젝트 요구 사항중 CRUD 기능을 최대한 구현해보려 했습니다.

### 2. 개발중 어려움
- 처음에 DB연동을 mySQL로 시도했으나 오류 해결이 어려워 sqLite로 변경했습니다.
- 게시글을 조회하는 부분에서 매핑이 제대로 되지 않어 오류를 겪었습니다.
- 여러 게시판에 데이터를 저장하고 각각 불러오는 부분을 아직 구현하지 못했습니다.
- 댓글 구현 부분도 아직 못했습니다..

### 필수 기능 엔드포인트 (제안)

- 게시판 보기: `/boards/{:boardId}/`
- 게시글 작성하기: `/boards/{:boardId}/article/`
- 게시글 보기: `/article/{:articleId}`
- 게시글 수정하기: `/article/{:articleId}/update/`
- 게시글 삭제하기: `/article/{:articleId}/delete/`
- 댓글 작성하기: `/article/{:articleId}/comment/`
- 댓글 삭제하기: `/article/{:articleId}/comment/{:commentId}/delete/`

### 3. JPA
JPA - Hibernate를 사용하여 jpa.hiberante.ddl-auto: update로 설정되어 있어
jpa.hiberante.ddl-auto: create로 변경해야 합니다.