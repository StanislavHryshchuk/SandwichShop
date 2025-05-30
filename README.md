🥪 Welcome to the Sandwich Shop Console Application!
This application simulates a full-featured sandwich ordering system built using Java. It allows users to fully customize their sandwich orders — choosing bread types, sandwich sizes, toppings (meats, cheeses, and regular toppings), sauces, and sides — with real-time price calculation and a detailed receipt upon checkout. Great for demonstrating object-oriented principles, user interaction via the CLI, and Java collection handling.

---
<details>
  <summary>🧾 README FILE MENU</summary>

  <details>
    <summary>🛠 Technologies Used</summary>

  * Java 17+
  * File I/O
  * Collections API
  * Java Time API

  </details>

  <details>
    <summary>🧠 Features</summary>

  #### 🏠 Home Screen
  * New Order
  * Exit

  #### 📋 Order Menu
  * Add Sandwich  
    * Bread (type, size)  
    * Meat Toppings  
    * Cheese Toppings  
    * Regular Toppings  
    * Sauces  
    * Sides  
    * Toasted (yes/no)  
  * Add Drink  
  * Add Chips  
  * Signature Sandwiches  
  * Checkout  
  * Cancel Order  
  
  </details>

<details>
  <summary>💻 Application Interface</summary>

  ### Home Screen: 
  ![alt text](src/main/resources/pictures/homeScreen.PNG)

  ### Order Screen:
  ![alt text](src/main/resources/pictures/orderScreen.PNG)
  
  ### Topping Screen:
  ![alt text](src/main/resources/pictures/toppingScreen.PNG)
   
  </details>

  <details>
    <summary>📂 File Structure</summary>

  <details>
    <summary>🧱 builders</summary>

  * 🛠️ `OrderBuilder.java`  
  * 🧰 `SandwichBuilder.java`  
  * 👨‍🍳 `SignatureSandwich.java`
  * 🧑‍🍳 `SignatureSandwichCustomize.java`

  </details>

  <details>
    <summary>🧩 enums</summary>

  * 🧩 `BreadSize.java`

  </details>

  <details>
    <summary>📝 filemanager</summary>

  * 🧾 `ReceiptFileManager.java`

  </details>

  <details>
    <summary>📦 modele</summary>

  * 🍞 `Bread.java`  
  * 🧀 `CheeseTopping.java`  
  * 🧺 `Chips.java`  
  * 🧃 `Drink.java`  
  * 🥓 `MeatTopping.java`  
  * 🧾 `Order.java`  
  * 🥬 `RegularTopping.java`  
  * 🥪 `Sandwich.java`  
  * 🧂 `Sauce.java`  
  * 🍟 `Sides.java`   
  * 🧩 `Topping.java` (abstract base class)

  </details>

  <details>
    <summary>🖥️ ui</summary>

  * 🏠 `HomeScreen.java`  
  * ▶️ `Main.java`

  </details>
  <details>
    <summary>🧪 Testing</summary>

  * Unit tests can be added using **JUnit 5**.
  * Focus areas include:
    * Sandwich price calculation logic
    * Topping selection and validation
    * Order total correctness
    * File output via `ReceiptFileManager`
  
  </details>

  </details>
</details>


### 👤 Author
Stanislav Hryshchuk 
