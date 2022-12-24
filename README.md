# spring-boot-TA-App

Code Review Scheduling Assistant 


************************************************

Overview of the project:
I would like to create a web 2.0 application which would be a scheduling application to book time slot for code review. Through this platform, the students would be able to book their code review timing under their assigned TA as well as reschedule/cancel their slots. The TA's would also be update their available slots regularly to be up to date.

Every time a student logs into the application, he/she can book their time slots only under their allocated TA and not under others(option would be disabled). They can view their available time slots and click on any one of them. Incase the student is not able to accommodate their timing in the listed Schedule , they have the option to raise special request to the TA.

A list of all the Student the user purchases will be persisted to the database against the TA. The TA ha the ability to select a bunch of students from the DB. The TA also has the ability to move a student among any of the available TAs. The students can schedule such time slots for different subjects(courses) that they have registerd for .

Upon completion of Code review, the pro and cons of the code would be sent out by the TA to individual student.
