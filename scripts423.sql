SELECT s.name, s.age, f.name
FROM students AS s
         LEFT JOIN faculties AS f ON s.faculty_id = f.id

SELECT s.name, s.age, a.file_path
FROM students AS s
         RIGHT JOIN avatars AS a ON s.id = a.student_id


