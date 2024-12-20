# MyTeacher - Student Information System for Teachers 

This is an object-oriented programming project in Java. This file will serve as documentation. 

## FUNCTIONALITY
- user interaction 
- options menu 
- save function 
- load save data 
- create grade report file (for individual student or class)

---

### STUDENT CLASS

**variables:**
- name
- ID 
- grade 
- assignments

> students should only be accessable through their respective course. students are added to a course. students are referenced throughout the program by ID

**functions:**
- constructor 
- getName(): retrieve student's name 
- getID(): retrieve student's ID 
- getGrade(): retrieve student's letter grade and percentage
- getLetterGrade(): calculate and return letter grade based on grade
- setGrade(): allow teacher to manually change student's grade
- printAssignments(): display all of a student's assignments with the score
- displayStudentInfo(): display student's name, ID, and grade (letter+score)
- addAssignment(): add assignment to a student's Assignment's list 

### COURSE CLASS

**variables:**
- course name
- courseID
- students (list of type Student)
- assignments (list of type Assignment)
- class average (calculated from student overall scores)

**functions:**
- constructor 
- getAverage(): calculate class average, store in variable, and return 
- getAverageLetter(): return average class grade as char
- addStudent(): add a student to the course 
- removeStudent(): remove a student from the course 
- getStudents(): display all the students in the course 
- addAssignment(): add an assignment to the class and to all of the students in the class
- removeAssignment(): delete an assignment for whatever reason 

### ASSIGNMENT 

**variables:**
- name
- studentScore (what did the individual student get on this assignment)
- maxScore (maximum possible score on the assignment. DEFAULT: 100)
- description (describe the assignment)

**functions:**
- constructor (w/o description)
- constructor (w/ description)
- changeName(): change the name of the assignment 
- changeMaxScore(): change the maximum score of the assignment 
- changeStudentScore(): change a student's score on the assignment
- setDescription(): edit the assignment's description 
- getDescription(): display assignment description 
- getInfo(): display name, description, and maximum score

### EXAM *(INHERITS ASSIGNMENT)*

**variables:**
- passRate
- failRate
- averageScore

**functions:**
- getPassRate(): return pass rate
- getFailRate(): return fail rate
- getAverageScore(): calculate and return average exam score

### ADDITIONAL FUNCTIONALITY 
- generate student report into a file?

## SAVE DATA
- serialize files to save data? worry about this later 

## ROADMAP: 
- create all the objects, classes and make them functional 
- design user interaction
- implement data saving 
- UI? 
