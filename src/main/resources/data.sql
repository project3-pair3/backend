-- 유저 데이터 삽입
INSERT INTO users (user_id, password, nickname)
VALUES ('test1','1234','테스트1');

INSERT INTO users (user_id, password, nickname)
VALUES ('test2','1234','테스트2');

INSERT INTO users (user_id, password, nickname)
VALUES ('test3','1234','테스트3');

-- 카페 데이터 삽입
INSERT INTO cafe (cafe_name, user_id, address_city, address_district, address_detail, description, opening_time, closing_time, image_url, created_at, updated_at)
VALUES ('스타리 카페', 1, '서울시', '강남구', '테헤란로 123', '도심 속 조용한 휴식 공간입니다.', '09:00:00', '22:00:00', 'https://images.unsplash.com/photo-1509042239860-f550ce710b93', '2026-05-11 05:21:52', NOW());

INSERT INTO cafe (cafe_name, user_id, address_city, address_district, address_detail, description, opening_time, closing_time, image_url, created_at, updated_at)
VALUES ('그린 리프 카페', 2, '서울시', '강남구', '강남대로 545', '자연 친화적인 인테리어와 신선한 원두를 제공합니다.', '09:00:00', '22:00:00', 'https://images.unsplash.com/photo-1495474472287-4d71bcdd2085', '2026-05-11 05:21:52', NOW());

INSERT INTO cafe (cafe_name, user_id, address_city, address_district, address_detail, description, opening_time, closing_time, image_url, created_at, updated_at)
VALUES ('오션 뷰 커피', 3, '서울시', '강남구', '강남대로102길 21 지하1, 지상 1-3층', '탁 트인 바다를 보며 커피 한 잔의 여유를 즐기세요.', '09:00:00', '22:00:00', 'https://images.unsplash.com/photo-1501339819358-683c33f59630', '2026-05-11 05:21:52', NOW());

-- 메뉴 데이터 삽입
-- 1번 카페 (스타리 카페) 메뉴
INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
VALUES ('조각 치즈 케이크', 6500, 10, 1, 'CAKE', '2026-05-13 05:21:52', NOW());

INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
VALUES ('초코칩 쿠키', 3000, 20, 1, 'COOKIE', '2026-05-12 05:21:52', NOW());

-- 2번 카페 (그린 리프 카페) 메뉴
INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
VALUES ('산딸기 마카롱', 2800, 15, 2, 'MACARON', '2026-05-12 05:21:52', NOW());

INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
VALUES ('에그 타르트', 3500, 12, 2, 'TART', '2026-05-12 05:21:52', NOW());

-- 3번 카페 (오션 뷰 커피) 메뉴
INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
VALUES ('커스터드 푸딩', 4500, 8, 3, 'PUDDING', '2026-05-12 05:21:52', NOW());

INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
VALUES ('블루베리 타르트', 7000, 5, 3, 'TART', '2026-05-12 05:21:52', NOW());
--
---- 유저 데이터 삽입
--INSERT INTO users (user_id, password, nickname)
--VALUES ('test4','1234','테스트4');
--
--INSERT INTO users (user_id, password, nickname)
--VALUES ('test5','1234','테스트5');
--
--INSERT INTO users (user_id, password, nickname)
--VALUES ('test6','1234','테스트6');
--
---- 카페 데이터 삽입
--INSERT INTO cafe (cafe_name, user_id, address_city, address_district, address_detail, description, opening_time, closing_time, image_url, created_at, updated_at)
--VALUES ('서초구1 카페', 1, '서울시', '서초구', '테헤란로 123', '도심 속 조용한 휴식 공간입니다.', '09:00:00', '22:00:00', 'https://images.unsplash.com/photo-1509042239860-f550ce710b93', '2026-05-11 05:21:52', NOW());
--
--INSERT INTO cafe (cafe_name, user_id, address_city, address_district, address_detail, description, opening_time, closing_time, image_url, created_at, updated_at)
--VALUES ('서초구2 리프 카페', 2, '서울시', '강남구', '강남대로 545', '자연 친화적인 인테리어와 신선한 원두를 제공합니다.', '09:00:00', '22:00:00', 'https://images.unsplash.com/photo-1495474472287-4d71bcdd2085', '2026-05-11 05:21:52', NOW());
--
--INSERT INTO cafe (cafe_name, user_id, address_city, address_district, address_detail, description, opening_time, closing_time, image_url, created_at, updated_at)
--VALUES ('서초구3 뷰 커피', 3, '서울시', '강남구', '강남대로102길 21 지하1, 지상 1-3층', '탁 트인 바다를 보며 커피 한 잔의 여유를 즐기세요.', '09:00:00', '22:00:00', 'https://images.unsplash.com/photo-1501339819358-683c33f59630', '2026-05-11 05:21:52', NOW());
--
---- 메뉴 데이터 삽입
---- 1번 카페 (스타리 카페) 메뉴
--INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
--VALUES ('서초구1 치즈 케이크', 6500, 10, 4, 'CAKE', '2026-05-13 05:21:52', NOW());
--
--INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
--VALUES ('서초구1 쿠키', 3000, 20, 4, 'COOKIE', '2026-05-12 05:21:52', NOW());
--
---- 2번 카페 (그린 리프 카페) 메뉴
--INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
--VALUES ('서초구2 마카롱', 2800, 15, 5, 'MACARON', '2026-05-12 05:21:52', NOW());
--
--INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
--VALUES ('서초구2 타르트', 3500, 12, 5, 'TART', '2026-05-12 05:21:52', NOW());
--
---- 3번 카페 (오션 뷰 커피) 메뉴
--INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
--VALUES ('서초구3 푸딩', 4500, 8, 6, 'PUDDING', '2026-05-12 05:21:52', NOW());
--
--INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
--VALUES ('서초구3 타르트', 7000, 5, 6, 'TART', '2026-05-12 05:21:52', NOW());
--
---- 카페 데이터 삽입
--INSERT INTO cafe (cafe_name, user_id, address_city, address_district, address_detail, description, opening_time, closing_time, image_url, created_at, updated_at)
--VALUES ('스타리 카페', 1, '수원시', '강남구', '테헤란로 123', '도심 속 조용한 휴식 공간입니다.', '09:00:00', '22:00:00', 'https://images.unsplash.com/photo-1509042239860-f550ce710b93', '2026-05-11 05:21:52', NOW());
--
--INSERT INTO cafe (cafe_name, user_id, address_city, address_district, address_detail, description, opening_time, closing_time, image_url, created_at, updated_at)
--VALUES ('그린 리프 카페', 2, '수원시', '강남구', '강남대로 545', '자연 친화적인 인테리어와 신선한 원두를 제공합니다.', '09:00:00', '22:00:00', 'https://images.unsplash.com/photo-1495474472287-4d71bcdd2085', '2026-05-11 05:21:52', NOW());
--
--INSERT INTO cafe (cafe_name, user_id, address_city, address_district, address_detail, description, opening_time, closing_time, image_url, created_at, updated_at)
--VALUES ('오션 뷰 커피', 3, '수원시', '강남구', '강남대로102길 21 지하1, 지상 1-3층', '탁 트인 바다를 보며 커피 한 잔의 여유를 즐기세요.', '09:00:00', '22:00:00', 'https://images.unsplash.com/photo-1501339819358-683c33f59630', '2026-05-11 05:21:52', NOW());
--
---- 메뉴 데이터 삽입
---- 1번 카페 (스타리 카페) 메뉴
--INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
--VALUES ('수원시1 치즈 케이크', 6500, 10, 7, 'CAKE', '2026-05-13 05:21:52', NOW());
--
--INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
--VALUES ('수원시1 쿠키', 3000, 20, 7, 'COOKIE', '2026-05-12 05:21:52', NOW());
--
---- 2번 카페 (그린 리프 카페) 메뉴
--INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
--VALUES ('수원시2 마카롱', 2800, 15, 8, 'MACARON', '2026-05-12 05:21:52', NOW());
--
--INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
--VALUES ('수원시2 타르트', 3500, 12, 8, 'TART', '2026-05-12 05:21:52', NOW());
--
---- 3번 카페 (오션 뷰 커피) 메뉴
--INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
--VALUES ('수원시3 푸딩', 4500, 8, 9, 'PUDDING', '2026-05-12 05:21:52', NOW());
--
--INSERT INTO menu (name, cost, stock, cafe_id, type, created_at, updated_at)
--VALUES ('수원시3 타르트', 7000, 5, 9, 'TART', '2026-05-12 05:21:52', NOW());