# Pay Test Task

## Overview

This project automates the checkout flow on a demo e-commerce website using Selenium WebDriver. The tests simulate a real-world checkout process, verifying essential steps such as product selection, cart functionality, and completing the checkout. This automation suite is designed to validate UI elements, product flows, and the overall stability of the checkout process.

## Approach

1. **Test Design**:
    - The tests are organized into modular classes that follow specific features of the checkout process (e.g., product selection, cart management).
    - A data-driven approach is used where possible, pulling test data from `.xlsx` files using Apache POI to reduce hardcoding and make tests reusable.

2. **Tools and Libraries**:
    - **Selenium WebDriver**: Used for automating interactions with the browser to test the checkout flow end-to-end.
    - **TestNG**: Manages test execution, generates reports, and provides assertions for verifying expected outcomes.
    - **Apache POI**: Reads Excel files (`.xlsx` format) to dynamically load test data for various test cases.
    - **WebDriverWait**: Implements explicit waits to handle dynamic web elements and ensure stability in testing flows.

3. **Project Structure**:
    - **src/main/java**: Contains utility classes and helper functions to support test execution.
    - **src/test/java**: Holds test cases organized by functionality within the checkout flow.
    - **resources**: Stores configuration files and external data files (such as Excel files for test data).
    -**Test.postman_collection**: For validating the creation of new users.
    - **jum_bug_report_file**: For reporting bugs found in the Jumia app.
4. **Checkout Flow**:
    - **User Signup (Manual)**: The script requires a new, fresh signup account for each test run due to demo site data reset.
    - **Product Selection and Cart Management**: Uses Selenium WebDriver to select products, add them to the cart, and proceed to checkout.
    - **Checkout and Verification**: Simulates the checkout steps and validates that the final steps complete successfully without errors.

## Important Note

- **Fresh Accounts Required**: Due to periodic data flushes on the demo website, ensure you provide a new signup account for each test run. Recent data may not be retained, so using an existing account may lead to errors.

## Setup and Execution

1. Clone the repository and open it in your preferred IDE.
2. Ensure all dependencies are installed by verifying the `pom.xml` file.
3. Execute the tests with `mvn clean test`.
4. Test results and logs are generated in the `target` directory after execution.

## Additional Notes
- Adjust any file paths for test data as necessary.
