import java.util.Scanner;  // Importing Scanner to get user input
import java.io.File;       // Importing File for reading from and writing to files
import java.io.FileWriter; // Importing FileWriter to write to files
import java.io.IOException; 
import java.util.ArrayList; // Importing ArrayList for dynamic storage of locations and crime types

public class CrimeReportingSystem {

    // Text file for storing user login details
    static String userFile = "users.txt";
    // Text file for storing crime reports
    static String crimeFile = "crime_reports.txt";

    // Main method to run the program
    public static void main(String[] args) {
        loginMenu(); // Start the system by showing the login menu
    }

    // Menu for login, either for officer or admin
    public static void loginMenu() {
        Scanner input = new Scanner(System.in); // Scanner to get user input
        System.out.println("Welcome to the Crime Reporting System");
        System.out.println("1. Login as Officer");
        System.out.println("2. Login as Admin");
        System.out.print("Select option: ");
        int choice = input.nextInt(); // Reading the user's choice
        
        if (choice == 1) {
            officerLogin(); // Call the officer login function
        } else if (choice == 2) {
            adminLogin(); // Call the admin login function
        } else {
            System.out.println("Invalid choice. Try again.");
            loginMenu(); // If invalid, reload the menu
        }
    }

    // Admin login method, with fixed username and password
    public static void adminLogin() {
        Scanner input = new Scanner(System.in); // Scanner to get admin login details
        System.out.print("Enter admin username: ");
        String username = input.nextLine(); // Get admin username
        System.out.print("Enter admin password: ");
        String password = input.nextLine(); // Get admin password
        
        // Check if the entered username and password match the admin credentials
        if (username.equals("admin") && password.equals("noa135")) {
            adminMenu(); // If correct, go to admin menu
        } else {
            System.out.println("Invalid login details. Try again.");
            adminLogin(); // Retry on failure
        }
    }

    // Admin menu for managing users
    public static void adminMenu() {
        Scanner input = new Scanner(System.in); // Scanner to get admin menu option
        System.out.println("Admin Menu");
        System.out.println("1. Add User");
        System.out.println("2. Delete User");
        System.out.println("3. Logout");
        System.out.print("Select option: ");
        int choice = input.nextInt(); // Reading admin's choice
        
        switch (choice) {
            case 1:
                addUser(); // Go to add user function
                break;
            case 2:
                deleteUser(); // Go to delete user function
                break;
            case 3:
                loginMenu(); // Logout and go back to login menu
                break;
            default:
                System.out.println("Invalid choice.");
                adminMenu(); // Reload admin menu on invalid choice
                break;
        }
    }

    // Method for adding users
    public static void addUser() {
        Scanner input = new Scanner(System.in); // Scanner to get new user details
        System.out.print("Enter new username: ");
        String username = input.nextLine(); // Get the new username
        System.out.print("Enter new password: ");
        String password = input.nextLine(); // Get the new password
        
        // Store user credentials in the user file
        try {
            FileWriter fw = new FileWriter(userFile, true); // Open the user file in append mode
            fw.write(username + "," + password + "\n"); // Write username and password to file
            fw.close(); // Close the file writer
            System.out.println("User added successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
        adminMenu(); // Return to admin menu after adding user
    }

    // Method for deleting users
    public static void deleteUser() {
        // For now, we will leave this feature and return to the admin menu.
        System.out.println("Delete user functionality to be implemented.");
        adminMenu();
    }

    // Officer login method
    public static void officerLogin() {
        Scanner input = new Scanner(System.in); // Scanner to get officer login details
        System.out.print("Enter officer username: ");
        String username = input.nextLine(); // Get officer's username
        System.out.print("Enter officer password: ");
        String password = input.nextLine(); // Get officer's password
        
        // Check the user credentials from the text file
        boolean validLogin = false; // To store whether login is valid or not
        
        try {
            Scanner sc = new Scanner(new File(userFile)); // Open the user file for reading
            while (sc.hasNextLine()) {
                String line = sc.nextLine(); // Read each line
                String[] userDetails = line.split(","); // Split each line by comma
                if (userDetails[0].equals(username) && userDetails[1].equals(password)) {
                    validLogin = true; // If login details match, set validLogin to true
                    break;
                }
            }
            sc.close(); // Close the file reader
        } catch (IOException e) {
            System.out.println("An error occurred while reading the user file.");
        }
        
        // If valid login, show officer menu
        if (validLogin) {
            officerMenu(); 
        } else {
            System.out.println("Invalid login details. Try again.");
            officerLogin(); // Retry on failure
        }
    }

    // Officer menu for reporting and searching crimes
    public static void officerMenu() {
        Scanner input = new Scanner(System.in); // Scanner to get officer menu option
        System.out.println("Officer Menu");
        System.out.println("1. Report Crime");
        System.out.println("2. Search Case by CaseID or ClientID/Passport");
        System.out.println("3. Logout");
        System.out.print("Select option: ");
        int choice = input.nextInt(); // Read officer's choice
        
        switch (choice) {
            case 1:
                reportCrime(); // Go to report crime function
                break;
            case 2:
                searchCase(); // Go to search case function
                break;
            case 3:
                loginMenu(); // Logout and return to login menu
                break;
            default:
                System.out.println("Invalid choice.");
                officerMenu(); // Reload officer menu on invalid choice
                break;
        }
    }

    // Method to report a crime
    public static void reportCrime() {
        Scanner input = new Scanner(System.in); // Scanner to get crime details
        System.out.print("Enter CRIMEID: ");
        String crimeID = input.nextLine(); // Get CRIMEID
        System.out.print("Enter Complainant's full name: ");
        String fullName = input.nextLine(); // Get complainant's full name
        System.out.print("Enter Complainant's ID/PASSPORT number: ");
        String idNumber = input.nextLine(); // Get complainant's ID or passport number
        System.out.print("Enter Complainant's Citizenship: ");
        String citizenship = input.nextLine(); // Get complainant's citizenship
        System.out.print("Enter Complainant's age: ");
        int age = input.nextInt(); // Get complainant's age
        input.nextLine(); // Consume the newline after entering an integer
        
        System.out.print("Enter Complainant's gender: ");
        String gender = input.nextLine(); // Get gender
        System.out.print("Enter Complainant's cellphone number: ");
        String cellphone = input.nextLine(); // Get cellphone number
        System.out.print("Enter Complainant's residential address: ");
        String address = input.nextLine(); // Get residential address
        System.out.print("Enter Complainant's occupation: ");
        String occupation = input.nextLine(); // Get occupation
        System.out.print("Enter Complainant's work telephone number: ");
        String telWork = input.nextLine(); // Get work telephone number
        System.out.print("Enter Complainant's work address: ");
        String workAddress = input.nextLine(); // Get work address
        System.out.print("Enter Complainant's postal address: ");
        String postalAddress = input.nextLine(); // Get postal address
        System.out.print("Enter Complainant's home language: ");
        String homeLanguage = input.nextLine(); // Get home language
        
        // Declaration for crime type
        System.out.println("Select the type of crime reported:");
        System.out.println("1. Phone stolen");
        System.out.println("2. Burglary");
        System.out.println("3. Murder");
        System.out.println("4. Gender Violence");
        System.out.println("5. Fraud");
        System.out.println("6. Kidnapping");
        System.out.println("7. Car Theft");
        System.out.println("8. Domestic Violence");
        System.out.println("9. Drug Possession");
        System.out.println("10. Arson");
        int crimeType = input.nextInt(); // Read selected crime type
        input.nextLine(); // Consume the newline

        System.out.print("Enter Accused name (if known, otherwise enter 'Unknown'): ");
        String accused = input.nextLine(); // Get name of accused person or 'Unknown'
        System.out.print("Enter Date of Crime (e.g., 01-01-2024): ");
        String crimeDate = input.nextLine(); // Get the date of the crime

        // Record all details in the crime file
        try {
            FileWriter fw = new FileWriter(crimeFile, true); // Open the crime file in append mode
            fw.write("CRIMEID: " + crimeID + ", Full Name: " + fullName + ", ID/PASSPORT: " + idNumber + 
                     ", Citizenship: " + citizenship + ", Age: " + age + ", Gender: " + gender + 
                     ", Cellphone: " + cellphone + ", Residential Address: " + address + 
                     ", Occupation: " + occupation + ", Work Tel: " + telWork + ", Work Address: " + workAddress + 
                     ", Postal Address: " + postalAddress + ", Home Language: " + homeLanguage + 
                     ", Crime Type: " + getCrimeName(crimeType) + ", Accused: " + accused + 
                     ", Date of Crime: " + crimeDate + "\n"); // Write all information to the file
            fw.close(); // Close the file writer
            System.out.println("Crime reported successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while recording the crime.");
        }
        officerMenu(); // Return to officer menu after reporting crime
    }

    // Helper method to get the crime name based on selected number
    public static String getCrimeName(int choice) {
        switch (choice) {
            case 1:
                return "Phone stolen";
            case 2:
                return "Burglary";
            case 3:
                return "Murder";
            case 4:
                return "Gender Violence";
            case 5:
                return "Fraud";
            case 6:
                return "Kidnapping";
            case 7:
                return "Car Theft";
            case 8:
                return "Domestic Violence";
            case 9:
                return "Drug Possession";
            case 10:
                return "Arson";
            default:
                return "Unknown Crime";
        }
    }

    // Method to search for cases by CaseID or ClientID/Passport number
    public static void searchCase() {
        Scanner input = new Scanner(System.in); // Scanner to get search criteria
        System.out.println("Search by: ");
        System.out.println("1. CaseID");
        System.out.println("2. ClientID/Passport number");
        int choice = input.nextInt(); // Get search type choice
        input.nextLine(); // Consume the newline
        
        String searchKey = "";
        if (choice == 1) {
            System.out.print("Enter CaseID to search: ");
            searchKey = input.nextLine(); // Get CaseID
        } else if (choice == 2) {
            System.out.print("Enter ClientID/Passport number to search: ");
            searchKey = input.nextLine(); // Get ClientID/Passport number
        } else {
            System.out.println("Invalid choice.");
            searchCase(); // Reload search case function if invalid
            return;
        }

        try {
            Scanner sc = new Scanner(new File(crimeFile)); // Open the crime file for reading
            boolean caseFound = false; // To track if a case is found
            while (sc.hasNextLine()) {
                String line = sc.nextLine(); // Read each line
                if (line.contains(searchKey)) { // Check if the line contains the search key
                    System.out.println("Case found: " + line); // Display the case details
                    caseFound = true; // Set caseFound to true
                }
            }
            sc.close(); // Close the file reader
            if (!caseFound) {
                System.out.println("No cases found for the given " + (choice == 1 ? "CaseID" : "ClientID/Passport number") + ".");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while searching.");
        }
        officerMenu(); // Return to officer menu after searching
    }
}
