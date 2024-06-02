# Doctor Appointment Booking Website

## Project Overview
The Doctor Appointment Booking Website is a web application that allows users to book appointments with doctors, and enables doctors to manage their schedules by accepting or rejecting appointment requests. This application is built using the Spring framework and employs a microservices architecture.

## Features
- **User Features:**
  - Book appointments with available doctors.
  - View appointment history.
  - Receive email notifications for appointment confirmations and cancellations.

- **Doctor Features:**
  - View upcoming appointments.
  - Accept or reject appointment requests.
  - Manage availability and schedule.

## Technology Stack
- **Backend:**
  - Spring Boot
  - Spring MVC
  - Spring Data JPA
  - Hibernate
  - Spring Starter Mail

- **Architecture:**
  - Microservices

## Project Structure
- **User Service:**
  - Manages user registration, authentication, and appointment booking.
- **Doctor Service:**
  - Manages doctor profiles, availability, and appointment handling.
- **Appointment Service:**
  - Coordinates appointment scheduling and notifications.
- **Notification Service:**
  - Sends email notifications for various events.

