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
- setGrade(): allow teacher to manually change student's letter grade
- getAssignments(): display all of a student's assignments with the score
- displayStudentInfo(): display student's name, ID, and grade (letter+score)
- add assignment to a student's profile 

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
- addStudent(): add a student to the course 
- removeStudent(): remove a student from the course 
- getStudents(): display all the students in the course 
- addAssignment(): add an assignment to the class and to all of the students in the class
- removeAssignment(): delete an assignment for whatever reason 

### ASSIGNMENT 

**variables:**
**functions:**

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
