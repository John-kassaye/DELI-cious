# DELI-cious

# Java Sandwich Ordering System

This is a Java-based console application for managing a sandwich ordering system. It allows users to build custom sandwiches, choose drinks and chips, and view a complete order summary with a receipt.

---

## 📌 Features

- Add multiple sandwiches to an order.
- Customize each sandwich with:
  - Type of bread
  - Regular and premium toppings
  - Toasted or not
  - Sauce
- Select drinks and chips
- Discount for customers with an account
- Split check option
- Calculate total cost of the order
- Display and generate order summary

---

## 🧱 Class Structure (UML)

![UML Diagram](DELI-cious/src/Diagram/UML_Diagram.webp)


---

## 📂 Project Structure

- `Menu` interface (base for all items)
- `Sandwich`, `Drink`, `Chips` (implementing `Menu`)
- `Toppings`, with subclasses `RegularToppings` and `PremiumToppings`
- `Order` class to manage complete orders
- `ReceiptManagement` to write receipt output
- Discount and split check feature included

---

## 🛠️ How to Run

1. Compile the code:
   ```bash
   javac *.java
   ```

2. Run the main program:
   ```bash
   java Main
   ```

---

## 📄 Sample Output

```
*****Sandwich*****
Size: Small
Bread: Wheat
Premium Topping: Bacon
Regular Toppings: Lettuce
Sauce: Mayo
Toasted: Yes
Price: $8.50

*****Drink*****
size: Small
Flavor: Coke

*****Chips*****
Type: Tortilla Chips

Here is your Total: $11.55
```

---

## 👨‍💻 Author

Yohannes Kassaye
