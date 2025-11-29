/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lastca_algorithm;

import java.util.*;

enum MenuOption {
    SORT, SEARCH, ADD_RECORDS, CREATE_TREE, EXIT;
    
    // converting user input to menu option and allowing case-sensitive inputs and ignoring spaces.
    public static MenuOption fromString(String input) {
        for (MenuOption option : MenuOption.values()) {
            if (option.name().equalsIgnoreCase(input.replace(" ", "_"))) {
                return option;
            }
        }
        return null;
    }
}

/**
 *
 * @author altangerel
 */
public class LastCA_Algorithm {
    // reaind the file
    static final String FILE_NAME = "src/employees.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in); // reading user input
        BinaryTree tree = new BinaryTree(); // initializing binary tree
        
        FileUtils.loadEmployees(tree, FILE_NAME);//lodaing employees from the file intpo the tree
        
        while (true) {
            //displaying menu options and valodations
            System.out.println("\nMenu Options:");
            for (MenuOption option : MenuOption.values()) {
                System.out.println(option.name().replace("_", " "));
            }
            //resind user input
            System.out.print("Enter choice: ");
            MenuOption choice = MenuOption.fromString(sc.nextLine().trim());
            
            if (choice == null) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }
            
            switch (choice) {
                case ADD_RECORDS:
                    Employee emp = readEmployee(sc);// reading empoyee details from user input
                    tree.insert(emp); //inserting into BTS
                    FileUtils.saveEmployee(emp, FILE_NAME); //saving it into the file
                    System.out.println("Record added and saved!");
                    break;
                
                case CREATE_TREE:
                    System.out.println("Binary tree is created automatically."); //binary tree is being created
                    break;
                
                case SORT:
                    Employee[] arr = getSortedEmployees(tree); //sorting employees by the full name
                    System.out.println("\nSorted Employees by Name:");
                    int cnt = 1;
                    for (Employee e : arr) {
                        //showing only first 20employees 
                        if (cnt == 21) {
                            break;
                        } else {
                            System.out.print(cnt + ". ");
                            System.out.println(e.display());
                        }
                        cnt++;
                    }
                    break;
                
                case SEARCH: //searching empoyees by first nane, last name or full name
                    System.out.print("Enter first name, last name, or full name to search: ");
                    String nameSearch = sc.nextLine();
                    Employee[] arrSearch = getSortedEmployees(tree); // sorted by full name
                    Employee found = binarySearchByName(arrSearch, nameSearch);

                    if (found != null) {
                        // Displaying name, department, and position
                        System.out.println("Name: " + found.getFirstName() + " " + found.getLastName()
                                + " | Department: " + found.getDepartment()
                                + " | Position: " + found.getPosition());
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                
                case EXIT: //exiting program
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
            }
        }
    }
    //reading empoyee details from user input
    private static Employee readEmployee(Scanner sc) {
        System.out.print("First name: ");
        String fn = sc.nextLine();
        System.out.print("Last name: ");
        String ln = sc.nextLine();
        System.out.print("Gender: ");
        String g = sc.nextLine();
        System.out.print("Email: ");
        String e = sc.nextLine();
        System.out.print("Salary: ");
        double s = Double.parseDouble(sc.nextLine());
        System.out.print("Department: ");
        String d = sc.nextLine();
        System.out.print("Position: ");
        String p = sc.nextLine();
        System.out.print("Job title: ");
        String j = sc.nextLine();
        System.out.print("Company: ");
        String c = sc.nextLine();
        return new Employee(fn, ln, g, e, s, d, p, j, c);
    }
    //returing sorted array of the employees by full name using merge sort
    private static Employee[] getSortedEmployees(BinaryTree tree) {
        List<Employee> list = new ArrayList<>();
        tree.inOrder(list);
        Employee[] arr = list.toArray(new Employee[0]);
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }
    //merge sort implementation for employee array by full name
    private static void mergeSort(Employee[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    //merge step for merge sort
    private static void merge(Employee[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    Employee[] L = new Employee[n1];
    Employee[] R = new Employee[n2];

    System.arraycopy(arr, left, L, 0, n1);
    System.arraycopy(arr, mid + 1, R, 0, n2);

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        String nameL = L[i].getFirstName() + " " + L[i].getLastName();
        String nameR = R[j].getFirstName() + " " + R[j].getLastName();
        if (nameL.compareToIgnoreCase(nameR) <= 0) {
            arr[k++] = L[i++];
        } else {
            arr[k++] = R[j++];
        }
    }

    while (i < n1) arr[k++] = L[i++];
    while (j < n2) arr[k++] = R[j++];
}
    //Binary search for employee by first name, last name, or full name. Assumes array is sorted by full name.
    private static Employee binarySearchByName(Employee[] arr, String searchQuery) {
        searchQuery = searchQuery.trim().toLowerCase();

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Employee midEmp = arr[mid];

            String fullName = (midEmp.getFirstName() + " " + midEmp.getLastName()).toLowerCase();
            String firstName = midEmp.getFirstName().toLowerCase();
            String lastName = midEmp.getLastName().toLowerCase();

            if (fullName.equals(searchQuery) || firstName.equals(searchQuery) || lastName.equals(searchQuery)) {
                return midEmp;
            }

            if (fullName.compareTo(searchQuery) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}
