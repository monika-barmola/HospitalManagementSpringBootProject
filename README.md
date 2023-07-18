# HospitalManagementSpringBootProject
HospitalManagementSpring
This is a Java Spring Boot web application developed for Hospital Management Staff. It provides REST APIs for staff signup/login, admitting new patients, fetching admitted patients, and discharging patients.

# Endpoints
GET /contacts: Retrieves a list of all contacts.
GET /contacts?zipCode={zipCode}: Retrieves a list of contacts with addresses in the specified zip code.
POST /contacts: Creates a new contact.

# Parameters
zipCode (required): The zip code to search for.
Request Body
For POST /contacts:
fullName (required): The full name of the contact.
dateOfBirth (required): The date of birth of the contact in the format yyyy-MM-dd.
address (optional): The address of the contact. If provided, it should include the following fields:
addressLine (required): The street address of the contact.
city (required): The city of the contact.
zipCode (required): The zip code of the contact.
Technologies Used
The Hospital Management System is built with the following technologies:

# Spring Boot

H2 Database

Logback

# Example
{ "name": "BBBBB", "age": 30, "room": "A101", "doctorName": "Dr. Smith", "admitDate": "2023-07-13", "expenses": 1500.0 }
