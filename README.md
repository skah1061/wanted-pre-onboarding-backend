# wanted-pre-onboarding-backend

원티드에서 주관하는 onboarding프로젝트 입니다.

채용공고 사이트의 간단한 백엔드 기능을 개발했습니다.

user가 가입하거나 회사가 가입하는 시스템은 없으므로 DB에 직접 넣어서 기능을 테스트 해야합니다.


# 기능
---

### 채용공고 등록
채용공고를 DB에 등록합니다.
회사는 등록된 채용공고와 매핑되어있습니다.

---

### 채용공고 조회
채용공고들을 모두 조회합니다.
등록된 채용공고의 데이터를 전체 조회합니다.

---
### 채용공고 상세 조회
채용공고 하나를 상세 조회합니다.
description이 나오도록 다른 Dto를 사용해서 구현하였습니다.

상세조회시 해당 회사의 다른 채용공고 데이터들을 같이 모두 출력합니다.


---


### 채용공고 삭제

채용공고를 삭제합니다.


선택한 id의 채용공고를 삭제합니다. 선택 id공고가 없을 시 없다고 출력합니다.

---

### 채용공고 수정

채용공고를 수정합니다 requestDto로 한번에 수정데이터를 넘겨주는 방식으로 set했으며,

@DynamicUpdate를 사용해 같은 수정사항을 Query로 날리지 않도록 처리했습니다.

---


### 채용공고 키워드 검색

키워드를 검색합니다. 

QueryDSL로 DB상세검색이 가능하게 하여 키워드에 맞는 단어가 포함된 공고를 검색합니다.

---

### 채용공고 지원

유저id와 채용공고id를 이용해 채용공고에 지원합니다.

유저나 채용공고id가 없을 시 없다는 메세지가 출력됩니다.


---

## ERD


<img src="https://github.com/skah1061/wanted-pre-onboarding-backend/assets/81159848/9334989a-9f38-4766-a905-8c14fb869d61">
