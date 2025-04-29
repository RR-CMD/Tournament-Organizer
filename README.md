# Football-Tournament Manager (Java)

Small, self-contained football / soccer league manager written in pure Java.  
The project’s goal is **learning-by-building**: instead of calling `java.util.Map`
or `Collections.sort`, all core data-structures and sorting algorithms are
implemented from scratch.

---

## 📜 Overview

The application lets you

1. **Create** a named tournament (e.g. `World Cup 1998 – Group A`).
2. **Register** up to **30** teams.
3. **Record** up to **1 000** matches  
   ‑ string format: `team1#goals1@goals2#team2`
4. **Print** a fully ranked standings table that follows common football
   tie-breakers (points → wins → GD → GF → fewest games → alphabetical).

Everything—teams, matches and tournaments—is stored in a **generic
sorted dictionary** that supports logarithmic-time look-ups, and league
tables are produced with classic in-place sorting algorithms bundled in
the repo.

---

## ✨ Features

* Generic `DictionaryInterface<K,V>` + concrete `SortedVectorDictionary<K,V>`
* **Eight** iterative sorts  
  *selection, insertion, shell (standard & “better gap”), bubble (standard &
  “better”), merge, heap*
* Regex validation & range checks when a match line is entered
* Automatic update of wins / draws / losses, points, goals for/against, GD
* Comparable `Team` objects so tie-break logic is centralised & reusable
* Top-level “tournament map” to keep **any number** of tournaments in memory

---

## ⚙️ How it works (architecture)

| Layer | Responsibility |
|-------|----------------|
| **`SortedVectorDictionary`** | Keeps entries ordered by key; enables binary-search insert & retrieval |
| **`MatchMapImplementation`** | Extends the dictionary, adds regex validation for match lines |
| **`Team`** | Stores per-team stats, implements `Comparable<Team>` with FIFA tie-breakers |
| **`TournamentImplementation`** | Holds a dictionary of teams + a global match map; every `addMatch` updates both teams |
| **`standings()`** | Converts the dictionary to an array, then runs **selection sort** from `ArraySorter` |

---

## 📝 Licence & Third-party Notice

All files **except** those listed below are  
© 2025 **Osamah Mulhem** and released under the MIT Licence (see `LICENSE`).

The following source files are *lightly adapted* from  
“Data Structures and Abstractions with Java, 4th Edition”  
by **Frank M. Carrano** & **Timothy M. Henry** (Pearson 2019):

* `src/Dictionary/DictionaryInterface.java`  
* `src/SortArray/Iterative/ArraySorter.java`
*`src/SortArray/Dictionary/SortedVectorDictionary.java` 

They are included **solely for educational use**.  
If you redistribute this repository, ensure that your use of those files
complies with Pearson’s policies or replace them with original
implementations.
