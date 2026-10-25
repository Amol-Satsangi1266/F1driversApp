# F1 Driver Mindmap & Team Simulation Backend

A prototype backend mindmap and simulation engine for Formula 1 teams. This application allows users to register themselves as F1 drivers, sign with specific racing teams, and simulate the organizational structure and operations of a functional F1 paddock.

## Features

| Feature | Description |
| :--- | :--- |
| **Driver Registration** | Allows users to create a profile and add themselves to the global F1 driver pool. |
| **Team Placement** | Assigns drivers to specific teams to construct the seasonal grid structure. |
| **Paddock Mindmap** | Visualizes relational data mapping drivers to their respective teams and staff. |
| **Workflow Simulation** | Simulates basic team operations, internal structures, and prototype workflows. |

## Tech Stack

* **IDE:** IntelliJ IDEA
* **Language:** Java (Spring Framework)
* **Database:** PostgresSQL

## Getting Started

### Prerequisites
* Ensure you have the matching runtime SDK installed (e.g., JDK, Node, or Python) depending on your project configuration.
* IntelliJ IDEA updated to the latest stable version.

### Setup Instructions
1. **Clone the Repository**
   ```bash
   git clone https://github.com/Amol-Satsangi1266/F1driversApp.git
   ```
2. **Open in IntelliJ IDEA**
    * Launch IntelliJ IDEA.
    * Select **File > Open** and select the cloned project root folder.
    * Allow the IDE to sync and download all necessary project dependencies.
3. **Run the Application**
    * Locate the main entry point file in your project directory.
    * Click the green **Run** arrow next to the main method or run script.

## Core API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/drivers` | Register a new user as an active F1 driver |
| `GET` | `/api/drivers` | View the global pool of registered drivers |
| `POST` | `/api/teams/{teamId}/join` | Assign a registered driver to a specific racing team |
| `GET` | `/api/teams/mindmap` | Retrieve the structural hierarchy of the entire paddock |
