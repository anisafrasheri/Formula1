# Formula 1 Championship Management System

This Java application is a graphical user interface (GUI) program designed for managing and analyzing Formula 1 championship data. The application allows users to view driver statistics, manage race data, and generate new race outcomes randomly. It is built using Java Swing for the GUI.

## Features

- **Driver Statistics**: View and sort statistics of Formula 1 drivers, including their positions in races and total points.
- **Race Management**: Add completed races, new races, and view all races.
- **Random Race Generation**: Generate and view random race results with simulated outcomes.
- **Search Functionality**: Search for drivers and view their race details and statistics.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher

### Running the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/anisafrasheri/Formula1.git

2. Navigate to the project directory:

   ```bash
    cd Formula1
   
3. Compile the Java files:
    ```bash
    javac -d bin src/Formula1/*.java

4. Run the application:
    ```bash
    java -cp bin Formula1.GUI


## Usage
Once the application is running, you will see a GUI with various panels and controls:

- **Top Panel**: Displays the main title of the application.
- **Left Panel**: Contains buttons to navigate and manage different functionalities.
- **Middle Panel**: Displays content based on the selected functionality (e.g., driver statistics, race management).
  
## Main Features
- **Search Drivers**: Use the search field to find specific drivers and view their detailed statistics.
- **View Driver Statistics**: Access and sort the driver statistics table by points or positions.
- **Add Completed Race**: Add a new completed race and view its results.
- **Add New Race**: Generate and view a new random race.
- **View All Races**: Access a comprehensive list of all races with details.
  
## Code Overview
The main classes and their responsibilities:

- **GUI**: Handles the GUI creation and interaction logic. It sets up panels, buttons, and tables to display data and manage user actions.
- **ShoferiFormula1**: Represents a Formula 1 driver with attributes such as name, team, and race statistics.
- **GaraFormula1**: Represents a Formula 1 race with its date and driver positions.
- **MenaxhimKampionatiFormula1**: Manages the championship data, including loading, saving, and calculating points.

## Contributing
Contributions are welcome! If you have suggestions, bug reports, or feature requests, please open an issue or submit a pull request.

## License
This project is licensed under the MIT License. See the [LICENSE](https://github.com/anisafrasheri/Formula1/blob/50b20960f3fa5bb6867b50f473c7d44f43347557/LICENSE) file for details.

## Acknowledgments
Java Swing for GUI components.
Random number generation for simulating race outcomes.
