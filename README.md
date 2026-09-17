```text
UrbanLadder-Automation/
└── UrbanladderWeb/
    ├── src/
    │   ├── main/
    │   │   └── java/
    │   │       └── org/
    │   │           └── example/
    │   │               └── App.java
    │   └── test/
    │       ├── java/
    │       │   ├── TestRunner/
    │       │   │   └── runnerFile.java
    │       │   ├── homePage/
    │       │   │   └── stepDef.java
    │       │   └── org/
    │       │       └── example/
    │       │           └── AppTest.java
    │       └── resources/
    │           └── home.feature
    ├── target/
    ├── pom.xml
    └── README.md
# UrbanLadder-Automation
UrbanLadder Automation
# UrbanLadder Automation Testing Framework

An end-to-end UI automation testing framework for UrbanLadder built using Cucumber BDD, Selenium WebDriver, and TestNG.

## 🚀 Project Overview
This project automates the primary user journey on the UrbanLadder website, covering home page validation, product search, filter application, cart interactions, and checkout workflow.

## 🛠️ Tech Stack
* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **BDD Framework:** Cucumber (Gherkin)
* **Testing Framework:** TestNG

## 📌 Test Scenario Covered
* **Launch Browser:** Navigates to UrbanLadder and validates home page URL loading.
* **Search Product:** Searches for "Sofa" and handles promotional popups.
* **Filter Results:** Applies product filters (e.g., "Fabric Sofa Sets") using Actions class hover and check-box selection.
* **Add to Cart:** Selects a target product item and adds it to the shopping cart using explicit waits.
* **Checkout Flow:** Fills in shipping details (Email, Pincode, Address, Name, Mobile Number) and asserts successful redirect to the payment page before terminating the browser instance.
