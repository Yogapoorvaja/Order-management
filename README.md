# Order Management System

A full-stack order management system with React frontend and Spring Boot backend, integrated with AWS services.

![Dashboard Preview](https://i.imgur.com/JKQlzYl.png) *(Example screenshot - add your own later)*

## Features

- **Frontend** (React.js)
  - Create new orders with customer details
  - View all orders in dashboard
  - Order detail pages
  - Invoice PDF upload/download
  - Responsive UI with Tailwind CSS

- **Backend** (Spring Boot)
  - REST API endpoints
  - AWS S3 for file storage
  - DynamoDB for data persistence
  - SNS for notifications

## Tech Stack

**Frontend:**
- React.js (TypeScript)
- React Router
- Axios for API calls
- Tailwind CSS for styling
- React Toastify for notifications

**Backend:**
- Spring Boot (Java)
- Spring Web
- AWS SDK for Java
- DynamoDB
- S3
- SNS

**DevOps:**
- GitHub Actions CI/CD
- Maven build system

## Prerequisites

- Java 17+
- Node.js 18+
- AWS account with permissions
- Maven
- Git

## Installation

### Backend Setup

1. Clone the repository:
```bash
git clone https://github.com/Yogapoorvaja/order-management.gi
cd order-service
