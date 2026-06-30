# CrimeReportingSystem
First Year Programming1 Project

# Overview
This Java program is a simple console-based Crime Reporting System with two user roles: Admin and Officer. It stores data in text files (users.txt for login details and crime_reports.txt for crime records).

Admins log in using fixed credentials (admin / noa135) and can add new officer accounts (saved to users.txt). A delete user option exists but is not fully implemented.

Officers log in using credentials stored in users.txt. Once authenticated, they can report crimes, search for cases, or log out. Reporting a crime involves entering complainant details and selecting a crime type. The data is saved to crime_reports.txt.

Officers can search cases by Case ID or complainant ID/passport number. The system scans the file and displays matching records if found.

This project demonstrates basic Java concepts such as user input, menus, file handling, and simple data storage. It is a beginner-level system and can be improved with features like secure password storage, better validation, database integration, and a graphical interface.

