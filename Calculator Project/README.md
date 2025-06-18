# 🧮 JavaFX Calculator App

![JavaFX](https://img.shields.io/badge/JavaFX-GUI-blue) ![Status](https://img.shields.io/badge/Status-Completed-brightgreen) ![License](https://img.shields.io/badge/License-MIT-lightgrey)

> A sleek, interactive calculator built using JavaFX.  
> Handles basic arithmetic operations with a clean UI and responsive design.

---

## 🚀 Features

- ➕ Addition  
- ➖ Subtraction  
- ✖️ Multiplication  
- ➗ Division (with zero-division handling)  
- 🔄 Clear (`C`)  
- ✅ Result (`=`) with immediate output  
- 📱 Responsive button grid and large display

---

## 🎯 Tech Stack

| Technology | Purpose |
|------------|---------|
| Java       | Core programming language |
| JavaFX     | GUI design and controls |

---

## 📸 Screenshot

> Here's what the app looks like during use:

![JavaFX Calculator Screenshot](./calculator_screenshot.png)

---

## 🧠 Logic Overview

- User input is handled using a `TextField`.
- Buttons are dynamically created using a string array for layout clarity.
- On operator input, the app stores the first number and waits for the second.
- On pressing `=`, the calculation is performed using a `switch` statement.
- Handles division-by-zero errors gracefully by displaying `"Error"`.

---

## 🛠 How to Run

### 📥 Prerequisites

- Java 11 or above
- JavaFX SDK installed and configured

### ▶️ Run Instructions

1. Clone or download this project.
2. Make sure JavaFX SDK is added to your module path.
3. Use the following VM arguments when running:

