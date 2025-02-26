<div align="center">
  <h1>Course Registration System (CRS)</h1>
  <img src="course_reg_system\src\img\ijse@1x.png" alt="IJSE" width="100"/>
</div>

![Java](https://img.shields.io/badge/Java-21%2B-orange)
![JavaFX](https://img.shields.io/badge/JavaFX-11%2B-blueviolet)
![MySQL](https://img.shields.io/badge/MySQL-Latest-blue)

> **Streamline your institution's registration process with comprehensive solution**

## 📋 Overview

The Course Registration System (CRS) automates the academic registration process at educational institutions. This powerful platform enables students to efficiently manage their academic schedules while providing faculty and administrative staff with robust tools to maintain and track course and student data.

## ✨ Features

```
┌─────────────────────────────────────────────┐
│                                             │
│  ⚙️  User Management                        │
│     • Authentication & Authorization        │
│     • Role-based access control             │
│                                             │
│  📚 Course Management                       │
│     • Create, read, update, delete courses  │
│     • Manage prerequisites                  │
│                                             │
│  👥 Student Management                      │
│     • Comprehensive student records         │
│     • Profile management                    │
│                                             │
│  📝 Enrollment Services                     │
│     • Course registration                   │
│     • Automated Prerequisites Checking      │
│     • Enrollment history                    │
│     • Course withdrawal                     │
│                                             │
│  📊 Reporting Tools                         │
│     • Course enrollment Reports             │
│     • Student Academic Reports              │
│                                             │
└─────────────────────────────────────────────┘
```

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 21 or later
- JavaFX 11 or later
- MySQL database

### External Dependencies

- Java MySQL connector
- JavaFX libraries

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Dettlaff404/Course-Registration-System-CRS-
   cd Course-Registration-System-CRS-
   ```

2. **Configure the database**
   ```bash
   # Create a new MySQL database using the provided SQL file
   mysql -u [username] -p [database_name] < crs_db_AshanManamperi.sql
   ```

3. **Launch the application**
   ```bash
   # Navigate to the source directory
   cd course_reg_system/src
   
   # Execute the main application file
   java App
   ```

## 🔧 Configuration

Adjust database connection settings in the configuration file before running the application.

## 📷 User Guide with Screenshots

***LogIn Portal***
<div align="center">
  <img src="screenshots/loginportal1.png" alt="LogIn Portal img" width="400" />
  <img src="screenshots/loginportal2.png" alt="LogIn Portal img" width="400" />
  <img src="screenshots/loginportal3.png" alt="LogIn Portal img" width="400" />
</div>

> ***LogIn portal allows users** (Admin which includes faculty and staff members and Students) **to effectively log in to there respective portals. If the user enters an invalid student id/ admin id or a password, relative error messages will be triggered.***

***Student Portal***
<div align="center">
  <img src="screenshots/studentportal.png" alt="Student Portal img" height="300" />
   <br>
  <img src="screenshots/studentportal2.png" alt="Student Portal img" height="300" />
  <br>
  <img src="screenshots/studentportal3.png" alt="Student Portal img" height="300" />
  <img src="screenshots/studentportal4.png" alt="Student Portal img" height="300" />
  <img src="screenshots/studentportal5.png" alt="Student Portal img" height="300" />
  <img src="screenshots/studentportal6.png" alt="Student Portal img" height="300" />
</div>

> ***Student Portal allows registered students in the system to access their Academic Report, Currently Following Courses** (where they can drop a selected course if its not passed 2 weeks after registering to the course) **and Courses Panel** (where they can enroll on new courses if they have completed the prerequisites for the course and it has enrollment spots left to be enrolled)*

***Admin Portal***
<div align="center">
  <img src="screenshots/adminportal.png" alt="Admin Portal img" height="300" />
   <br>
  <img src="screenshots/adminportal2.png" alt="Admin Portal img" height="300" />
   <br>
  <img src="screenshots/adminportal3.png" alt="Admin Portal img" height="300" />
  <img src="screenshots/adminportal4.png" alt="Admin Portal img" height="300" />
   <br>
  <img src="screenshots/adminportal5.png" alt="Admin Portal img" height="300" />
  <img src="screenshots/studentportal2.png" alt="Admin Portal img" height="300" />
</div>

> ***Admin Portal consists of two panels Courses** (where admins can add a new course, update existing course data or delete a course. Moreover can get a report on courses which records all students data who have completed the course with pass rates. Additionally admins can access Grade Course Panel for each course here where they can use it to either grade students or delete there enrollment) **and Students Panel** (Where admins can add new students, update student data of existing students and get a Academic Report of students' course progressions).*


---

<p align="center">
  <i>Developed with ❤️ for educational institutions</i>
</p>
