# Media Rental Management System

This project is a Java-based application designed to simulate the operations of a media rental business. It allows you to manage various types of media, such as albums and movies, handle customer data, and process rental transactions.

## Features

- **Media Management**: Handle different types of media including `Album` and `Movie`.
- **Customer Management**: Manage customer information and their rental activities.
- **Rental Operations**: Rent and return media items, and track inventory through the `MediaRentalManager` class.
- **Extensible Design**: Easily add new media types by extending the `Media` class.

## Project Structure

- **`Album.java`**: Represents an album, including details like artist and songs.
- **`Movie.java`**: Represents a movie, with attributes like title, rating, and genre.
- **`Customer.java`**: Manages customer information, including name, address, and rental history.
- **`Media.java`**: A superclass for different types of media, providing common attributes like title and code.
- **`MediaRentalManager.java`**: The core class that manages rentals, returns, and inventory.
- **`MediaRentalManagerInt.java`**: An interface that defines the methods required for managing media rentals.

## How to Use

1. **Clone the Repository**: Download or clone the repository to your local machine.
   ```bash
   git clone https://github.com/yourusername/media-rental-management.git
