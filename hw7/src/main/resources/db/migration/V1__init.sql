CREATE TABLE students (
  id        bigserial PRIMARY KEY,
  name      VARCHAR(255),
  age       INT
);

INSERT INTO students (name, age) VALUES
('Student_01', 24),
('Student_02', 21),
('Student_03', 19),
('Student_04', 29),
('Student_05', 28),
('Student_06', 36),
('Student_07', 39),
('Student_08', 23),
('Student_09', 18),
('Student_10', 22);