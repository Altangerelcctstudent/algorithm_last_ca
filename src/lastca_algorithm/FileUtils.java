/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lastca_algorithm;
import java.io.*;


/**
 *
 * @author altangerel
 */
public class FileUtils { //reading and writing employee data to the file
    public static void saveEmployee(Employee emp, String fileName) { // saving an employee to the file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(emp.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving employee: " + e.getMessage());
        }
    }
    // loads all employee from the file and inserts them into the tree
    public static void loadEmployees(BinaryTree tree, String fileName) {
        File file = new File(fileName);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 9) {
                    tree.insert(new Employee(
                            parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim(),
                            Double.parseDouble(parts[4].trim()), parts[5].trim(), parts[6].trim(),
                            parts[7].trim(), parts[8].trim()
                    ));
                }
            }
            System.out.println("Employees loaded from file.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
    