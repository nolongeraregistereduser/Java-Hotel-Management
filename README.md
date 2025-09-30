# Java Hotel Management System

A console-based hotel reservation management system built with Java, implementing clean architecture principles with repository pattern and service layer separation.

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Code Documentation](#code-documentation)
- [Future Enhancements](#future-enhancements)

## 🏨 Overview

This project is a comprehensive hotel management system that allows users to browse hotels, make reservations, and manage their bookings. The application is built using object-oriented programming principles and follows a layered architecture pattern, separating concerns between data models, repositories, and business services.

The system comes pre-loaded with several Moroccan hotels (La Mamounia, Royal Mansour, Four Seasons Resort Marrakech, Sofitel Casablanca Tour Blanche, and Kenzi Tower Hotel) for demonstration purposes.

## ✨ Features

### Authentication System
- **User Registration**: New users can create accounts with email and password
- **User Login**: Secure login system with credential validation
- **Session Management**: Active session tracking for logged-in users
- **User Logout**: Clean session termination

### Hotel Management
- **Browse All Hotels**: View complete list of available hotels with details
- **Filter Available Hotels**: Display only hotels with available rooms
- **Search by Rating**: Filter hotels by minimum rating (0.0 - 5.0)
- **Hotel Information Display**: Shows hotel address, available rooms, and rating

### Reservation System
- **Make Reservations**: Book hotel rooms for specified number of nights
- **View Reservations**: List all reservations for logged-in user
- **Cancel Reservations**: Cancel existing bookings
- **Automatic Room Management**: Automatically updates room availability upon booking/cancellation
- **Reservation Tracking**: Each reservation includes unique ID, timestamp, hotel details, and duration

## 🏗️ Architecture

The application follows a **three-layer architecture** pattern:

### 1. Model Layer (`models/`)
Represents the domain entities:
- **Client**: User accounts with credentials and profile information
- **Hotel**: Hotel properties including address, available rooms, and ratings
- **Reservation**: Booking records linking clients to hotels with timestamps

### 2. Repository Layer (`repositories/`)
Implements the **Repository Pattern** for data access:
- **Interface Contracts**: `ClientRepository`, `HotelRepository`, `ReservationRepository`
- **In-Memory Implementation**: `InMemoryClientRepository`, `InMemoryHotelRepository`, `InMemoryReservationRepository`
- **CRUD Operations**: Create, Read, Update, Delete functionality for each entity
- **Custom Queries**: Specialized find methods (by email, by availability, by rating, etc.)

### 3. Service Layer (`services/`)
Contains business logic and orchestration:
- **AuthService**: Handles user authentication, registration, and session management
- **ReservationService**: Manages reservation creation and cancellation with business rules

### 4. Presentation Layer
- **Main.java**: Console-based user interface with interactive menus

## 🛠️ Technology Stack

- **Language**: Java (JDK 8 or higher)
- **Data Storage**: In-memory collections (HashMap)
- **Architecture Pattern**: Repository Pattern + Service Layer
- **Design Principles**: 
  - Dependency Injection
  - Interface Segregation
  - Single Responsibility Principle

## 📁 Project Structure

```
Java-Hotel-Management/
├── src/
│   ├── Main.java                              # Application entry point
│   ├── models/
│   │   ├── Client.java                        # User entity
│   │   ├── Hotel.java                         # Hotel entity
│   │   └── Reservation.java                   # Reservation entity
│   ├── repositories/
│   │   ├── ClientRepository.java              # Client repository interface
│   │   ├── InMemoryClientRepository.java      # Client in-memory implementation
│   │   ├── HotelRepository.java               # Hotel repository interface
│   │   ├── InMemoryHotelRepository.java       # Hotel in-memory implementation
│   │   ├── ReservationRepository.java         # Reservation repository interface
│   │   └── InMemoryReservationRepository.java # Reservation in-memory implementation
│   └── services/
│       ├── AuthService.java                   # Authentication service
│       └── ReservationService.java            # Reservation business logic
├── .gitignore
└── README.md
```

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- A terminal or command prompt

### Installation & Compilation

1. **Clone the repository**
   ```bash
   git clone https://github.com/nolongeraregistereduser/Java-Hotel-Management.git
   cd Java-Hotel-Management
   ```

2. **Compile the project**
   ```bash
   javac -d out src/models/*.java src/repositories/*.java src/services/*.java src/Main.java
   ```

3. **Run the application**
   ```bash
   java -cp out Main
   ```

## 📖 Usage

### For New Users

1. **Start the application** - Run the compiled Main class
2. **Register** - Select option 1 from the main menu
   - Enter your email address
   - Create a password
3. **Login** - Select option 2 from the main menu
   - Enter your registered email
   - Enter your password

### For Logged-In Users

Once logged in, you can:

1. **View All Hotels** (Option 1)
   - Displays complete list of hotels with room availability and ratings

2. **View Available Hotels** (Option 2)
   - Shows only hotels with available rooms

3. **Search by Rating** (Option 3)
   - Filter hotels by minimum rating threshold

4. **Make a Reservation** (Option 6)
   - Select from available hotels
   - Specify number of nights
   - System automatically updates room availability

5. **View & Cancel Reservations** (Option 7)
   - View all your active reservations
   - Cancel any reservation
   - Room availability automatically restored

6. **Logout** (Option 4)
   - End your session

7. **Exit Application** (Option 5)

### Sample Workflow

```
1. Register with email: user@example.com
2. Login with credentials
3. Browse available hotels
4. Make a reservation at "La Mamounia" for 3 nights
5. View your reservations
6. Cancel a reservation if needed
7. Logout
```

## 📚 Code Documentation

### Key Classes and Methods

#### AuthService
```java
boolean register(String email, String password)     // Create new user account
boolean login(String email, String password)        // Authenticate user
boolean logout(String email)                        // End user session
boolean isLoggedIn(String email)                    // Check session status
```

#### ReservationService
```java
boolean makeReservation(String email, UUID hotelId, int nights)  // Create booking
boolean cancelReservation(UUID reservationId, String email)      // Cancel booking
```

#### Hotel
```java
boolean isAvailable()                               // Check if rooms available
// Properties: hotelId, address, availableRooms, rating
```

#### Client
```java
// Properties: clientId, fullName, email, password
```

#### Reservation
```java
// Properties: reservationId, timestamp, hotelId, clientId, nights
```

### Repository Interfaces

All repositories implement standard CRUD operations:
- `save(Entity entity)` - Create or update
- `findById(UUID id)` - Retrieve by ID
- `findAll()` - List all entities
- `update(Entity entity)` - Update existing
- `delete(UUID id)` - Remove entity

Plus specialized queries like:
- `findByEmail(String email)` - Client lookup
- `findByAvailability(boolean onlyAvailable)` - Hotel filtering
- `findByClient(UUID clientId)` - User's reservations

## 🔮 Future Enhancements

### Potential Improvements
1. **Persistent Storage**
   - Replace in-memory storage with database (MySQL, PostgreSQL)
   - Implement JPA/Hibernate for ORM

2. **Enhanced Security**
   - Password hashing (BCrypt)
   - JWT token-based authentication
   - Role-based access control (Admin/User)

3. **Advanced Features**
   - Room types (Single, Double, Suite)
   - Pricing system with dynamic rates
   - Payment processing integration
   - Email confirmation for bookings
   - Booking date ranges (check-in/check-out)
   - Multi-room reservations

4. **User Interface**
   - Web-based UI (Spring Boot + React/Angular)
   - Mobile application
   - Admin dashboard for hotel management

5. **Business Logic**
   - Cancellation policies
   - Refund management
   - Loyalty points system
   - Reviews and ratings by users
   - Hotel amenities and photos

6. **Technical Improvements**
   - Unit testing (JUnit)
   - Integration testing
   - Logging framework (Log4j, SLF4J)
   - Exception handling framework
   - Input validation
   - API documentation (Swagger)

7. **Search Enhancements**
   - Location-based search
   - Price range filtering
   - Advanced search with multiple criteria
   - Sort by various attributes

## 👨‍💻 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📄 License

This project is available for educational purposes.

## 🙏 Acknowledgments

- Pre-loaded with sample Moroccan hotels for demonstration
- Built as a learning project demonstrating Java best practices and design patterns
