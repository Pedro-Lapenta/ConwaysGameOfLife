# Conway's Game of Life (Java Implementation)

This is a simple Java implementation of [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life), a cellular automaton devised by mathematician John Conway. This project simulates the evolution of a grid of cells following a set of rules based on the state of neighboring cells.

## 📋 Features

- Randomized or dead-initialized grid  
- Clear terminal-based animation using UTF-8 characters  
- Configurable grid dimensions  

## 🧠 Game Rules

1. **Underpopulation:** Any live cell with fewer than two live neighbors dies.  
2. **Survival:** Any live cell with two or three live neighbors lives on.  
3. **Overpopulation:** Any live cell with more than three live neighbors dies.  
4. **Reproduction:** Any dead cell with exactly three live neighbors becomes a live cell.

## 🧱 Project Structure

```
src/
├── GridState.java     // Core class containing logic and grid manipulation
├── DeadState.java     // Subclass with all cells initialized to dead
└── Main.java          // Entry point for user interaction and game execution
```

## 🚀 How to Run

### Requirements

- Java 8 or later

### Compile and Run

```bash
javac *.java
java Main.java
```

You’ll be prompted to input the **height** and **width** of the grid. Afterward, the game will begin.

> ⚠️ The current `playGame()` method is set to run infinitely due to `for (int i = 0; i != repetitions; i--)`.  
> Update this condition for finite executions.

### Example Fix

```java
//GridState.java

for (int i = 0; i < repetitions; i++) {
    // your animation logic here
}
```

```java
//Main.java

gridState.playGame(number of repetitions); //initially set to 1
```

## 🧪 Sample Output

Example output in terminal (live cells: `■`, dead cells: `.`):

```
Conway's Game of Life:

..■.....
...■....
.■■.....
........
```

## ✏️ Customizing Initial State

You can extend `GridState` to create new initialization states.  
An example is the `DeadState` class where all cells start as dead.

## 📜 License

This project is open-source and free to use, licensed under the MIT License.

---
