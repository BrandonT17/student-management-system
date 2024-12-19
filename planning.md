# MyTeacher - Student Information System for Teachers 

## This is an object-oriented programming project in Java

### CLASSES

#### STUDENT CLASS
- name (STRING)
- student id (INT)
- grades (hashmap/map where key = assignment, and value = grade) (MAP)
- total grade = average of all grades (CHAR)

#### COURSE CLASS
- course name (STRING)
- students associated with course (perhaps a map?) (MAP, LIST, ARRAY)
- display full class list along with their total grades (FUNC)
- display class average (FUNC)

#### TEACHER HOME PAGE (MAIN METHOD)
- allow teacher to create new student and class objects 
- view average score for a particular assignment/exam?
- create assignment objects (exam will be parent class of assignment)

#### ASSIGNMENT 
- get assignment description
- get average grade for an assignment

##### EXAM INHERITS ASSIGNMENT
- only difference will be that exam will have a pass/fail average score 
    - pass rate 
    - fail rate 

