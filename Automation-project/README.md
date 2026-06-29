# 🧪 National Insurance Institute (BTL) Automation Testing Framework

A robust, enterprise-grade automated testing framework designed to validate critical web workflows, calculator components, and user flows on the official **National Insurance Institute of Israel (ביטוח לאומי)** portal.

This project implements a highly structured, scalable architecture designed for continuous integration, regression testing, and cross-browser quality assurance.

---

## ✨ Key Features

- **Automated Flow Validation:** Comprehensive end-to-end automation of complex state insurance calculations and dynamic forms.
- **Dynamic Search & Assertion:** Core test cases to validate search entry points, verifying result sets match strict expected criteria (e.g., Maternity Benefit calculations).
- **Multi-Step Wizard Tracking:** Programmatic step-by-step traversal of complex interactive registration forms (e.g., Bachur Yeshiva Insurance contribution calculator), checking state transitions (`Step 1` ➡️ `Step 2` ➡️ `Finish`) and asserting calculated financial balances.
- **Robust Locators:** Embedded Selenium locator mechanics utilizing robust dynamic XPath and ID selectors to interact with intricate governmental web platforms.

---

## 🏗 Architectural Design Patterns

This framework strictly adheres to industry-standard software engineering and test automation patterns:

### 1. Page Object Model (POM)
To ensure maximum maintainability, clean separation of concerns, and minimal code duplication, web pages are modeled as decoupled Java classes. Every page isolates its unique element locators (`By` objects) and operational behaviors/actions away from the test logic.

### 2. Classical Inheritance Hierarchy
- **`BaseTest`**: The foundational root layer that manages the `WebDriver` lifecycle and initializes elements via Selenium's `PageFactory`.
- **`BtlBasePage`**: Extends `BaseTest` to provide globally accessible utility wrappers used across the portal, such as header search execution (`Search()`) and multi-level navigation dropdown bars (`Nuvigate()`).
- **Component Pages (`BachurYeshiva`, `Maternuty_benefits`, `BtlContributions`)**: Inherit structural behavior from `BtlBasePage` while encapsulating specialized locators and granular flow actions for specific forms.

---

## 🛠 Tech Stack & Dependencies

- **Programming Language:** Java
- **Automation Core:** Selenium WebDriver
- **Test Runner & Framework:** JUnit 5 (Jupiter API)
- **Driver Management:** WebDriverManager (Automated browser binary management)
- **Design Pattern Tooling:** PageFactory Framework

---

## 📁 Repository Structure

```text
src/
├── BTL/ (Page Objects)
│   ├── BaseTest.java            # Initializes WebDriver & PageFactory elements
│   ├── BtlBasePage.java         # Global shared layout operations (Navigation, Search)
│   ├── HomePage.java            # Landing page wrapper object
│   ├── BtlContributions.java    # Insurance contributions directory page
│   ├── BachurYeshiva.java       # Multi-step calculation wizard object
│   └── Maternuty_benefits.java  # Search results page mapping for maternity calculations
└── test/java/ (Test Suites)
    └── btlTest.java             # JUnit 5 suite executing test configurations and assertions
