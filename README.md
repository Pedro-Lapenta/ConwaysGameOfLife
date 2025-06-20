# Conway's Game of Life (Java Implementation)

This is a simple Java implementation of [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life), a cellular automaton devised by mathematician John Conway. This project simulates the evolution of a grid of cells following a set of rules based on the state of neighboring cells.

## ⚠️ Unicode Display Warning

If Unicode characters are not displaying correctly, try the following:

### On Windows:
1. Open **Settings** > **Time & Language** > **Language & Region**.
2. Click **Administrative Language settings**.
3. Under **Language for non-Unicode programs**, click **Change system locale...**.
4. Enable the option: **"Use Unicode UTF-8 for worldwide language support"**.
5. Restart your computer for the changes to take effect.

If this still didn't fix the problem, try running this command in your terminal before executing your program:

```
chcp 65001
```

This sets the terminal's code page to UTF-8, which supports Unicode characters properly.

💡 Note: You may need to do this every time you open a new terminal window.


## 📋 Features

- Randomized, setted or dead-initialized grid  
- Clear terminal-based animation using UTF-8 characters  
- Configurable grid dimensions 

## 🖼️ Examples

Here are two examples showcasing the Game of Life in action:

### Gosper Glider Gun
![Gosper Glider Gun](gif/GosperGliderGun.gif)

### Randomly Generated Grid
![Random Grid](gif/RandomGrid.gif)


## 🧠 Game Rules

1. **Underpopulation:** Any live cell with fewer than two live neighbors dies.  
2. **Survival:** Any live cell with two or three live neighbors lives on.  
3. **Overpopulation:** Any live cell with more than three live neighbors dies.  
4. **Reproduction:** Any dead cell with exactly three live neighbors becomes a live cell.

## 🧱 Project Structure

```
src/
├── SettedStates/                      // Preset patterns for initializing the game
│   ├── GosperGliderGun.txt            // Text file defining the Gosper Glider Gun pattern
│   ├── Toad.txt                       // Text file defining the Toad oscillator pattern
│   ├── ...
│   └── (your_custom_pattern).txt      // You can add your own .txt files here
│
├── TestStates/                        // Test scenarios to validate game rules
│   ├── Overpopulation.txt             // Tests for overpopulation rule
│   ├── Reproduction.txt               // Tests for reproduction rule
│   ├── Survival.txt                   // Tests for survival rule
│   └── Underpopulation.txt            // Tests for underpopulation rule
│
├── GridState.java                     // Core class containing logic and grid manipulation
├── GridState.class                    // Compiled version of GridState.java
│
├── DeadState.java                     // Subclass with all cells initialized to dead
├── DeadState.class                    // Compiled version of DeadState.java
│
├── SettedState.java                   // Loads predefined states from files in SettedStates
├── SettedState.class                  // Compiled version of SettedState.java
│
├── UnitTesting.java                   // Contains unit tests for validating the system
├── UnitTesting.class                  // Compiled version of UnitTesting.java
│
├── Main.java                          // Entry point for user interaction and game execution
└── Main.class                         // Compiled version of Main.java
```

## 🚀 How to Run

### Requirements

- Java 8 or later

### Compile and Run

```bash
javac src/*.java
java src.Main
```

You’ll be prompted to input the **height** and **width** of the grid. Afterward, the game will begin.


## 🧪 Sample Output

Example output in terminal (live cells: `■`, dead cells: `.`):

```
Conway's Game of Life:

..■.....
...■....
.■■.....
........
```

## ➕ Adding Custom Patterns

You can add your own initial configurations for the game by simply placing .txt files into the SettedStates/ folder. These files will be read by the SettedState class and can be used as starting states for the simulation.

Each .txt file should represent a grid using characters (e.g., 1 for alive, 0 for dead) where each line corresponds to a row in the grid. Example:

```
00100
00100
00100
00000
00000
```

## 📜 License

This project is open-source and free to use, licensed under the MIT License.

---
