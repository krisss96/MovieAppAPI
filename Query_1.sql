UPDATE movie
SET
    hero_image = REPLACE(hero_image, 'static', ''),
    poster_path = REPLACE(poster_path, 'static', ''),
    soundtrack = REPLACE(soundtrack, 'static', ''),
    scene1 = REPLACE(scene1, 'static', ''),
    scene2 = REPLACE(scene2, 'static', ''),
    scene3 = REPLACE(scene3, 'static', ''),
    scene4 = REPLACE(scene4, 'static', '')
WHERE
    hero_image LIKE 'static%'
   OR poster_path LIKE 'static%'
   OR soundtrack LIKE 'static%'
   OR scene1 LIKE 'static%'
   OR scene2 LIKE 'static%'
   OR scene3 LIKE 'static%'
   OR scene4 LIKE 'static%';

START TRANSACTION;

UPDATE mood
SET mood_cover_path = CONCAT(LEFT(mood_cover_path, CHAR_LENGTH(mood_cover_path)-4), '.png')
WHERE LOWER(mood_cover_path) LIKE '%.bng';

COMMIT;