# CrimeReportingSystem
First Year Programming1 Project

# Overview
A Java based crime reporting system for the Namibian Police as they still use a paper-based system. This Java program is a simple console-based Crime Reporting System. It allows two types of users to use the system: an Admin and an Officer. The system stores information in text files, namely `users.txt` for officer login details and crime_reports.txt for reported crime cases.

The program starts by displaying a login menu. The user can choose to log in either as an Officer or as an Admin. If the user selects Admin, they must enter the correct admin username and password. In this program, the admin login details are fixed as admin for the username and noa135 for the password.

Once the Admin logs in successfully, the Admin Menu is displayed. The admin can add a new officer user by entering a username and password. These details are then saved into the users.txt file. There is also an option to delete a user, but this feature has not yet been fully implemented. The admin can also log out and return to the main login menu.

If the user logs in as an Officer, the program asks for the officer’s username and password. The system then checks the users.txt file to see whether those login details exist. If the username and password match what is stored in the file, the officer is allowed into the Officer Menu. If the details are incorrect, the officer is asked to try again.

The Officer Menu allows the officer to report a crime, search for a case, or log out. When reporting a crime, the officer must enter important details about the complainant, such as the complainant’s full name, ID or passport number, citizenship, age, gender, cellphone number, address, occupation, work telephone number, work address, postal address, and home language. The officer must also select the type of crime from a list, such as burglary, fraud, car theft, domestic violence, kidnapping, or arson.

After all the crime details are entered, the system saves the information into the crime_reports.txt file. The information is stored as one long line of text containing the crime ID, complainant details, crime type, accused person, and date of the crime. The program uses a helper method called `getCrimeName()` to convert the number selected by the officer into the actual crime name.

The system also allows an officer to search for a reported case. The officer can search either by Case ID or by the complainant’s ID/passport number. The program opens the crime_reports.txt file and checks each line to see whether it contains the search key entered by the officer. If a matching case is found, the full case details are displayed. If no match is found, the program tells the officer that no case was found.

Overall, this program demonstrates basic Java programming concepts such as user input, menus, conditional statements, switch statements, methods, file writing, file reading, and simple data storage. It is useful as a beginner-level system for understanding how information can be entered, saved, and searched in a text-based Java application.

However, the system is still basic and can be improved. For example, the delete user function is not yet implemented. The system also stores passwords in plain text, which is not secure. It does not validate all user inputs, and the search function uses simple text matching, which may return incorrect results if the same value appears in different parts of a case record. A more advanced version could use a database, encrypted passwords, better error handling, and a proper graphical user interface.

