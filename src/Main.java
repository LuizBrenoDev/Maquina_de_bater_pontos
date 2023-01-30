import model.entities.Employee;
import model.entities.Enterprise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("Welcome to the dot hitting point machine: ");
        System.out.print("Enterprise name: ");
        String name = sc.nextLine();

        System.out.print("Enter the arrival hour: ");
        LocalTime arrival = LocalTime.parse(sc.nextLine(), formatter);
        System.out.print("Enter the output hour: ");
        LocalTime output = LocalTime.parse(sc.nextLine(), formatter);

        Enterprise enterprise = new Enterprise(name, arrival, output);

        System.out.print("Enter the path to save the points: ");
        String pth = sc.nextLine();
        boolean created = new File(pth + "\\Points").mkdir();
        File points = new File(pth + "\\Points");
        System.out.println("New folder created");

        while (enterprise != null) {
                System.out.println("------Print--------");
                System.out.print("Arrival or leaving(a/l)? ");
                char reply = sc.nextLine().charAt(0);
                System.out.print("Employee name: ");
                String employeeName = sc.nextLine();
                Employee employee = new Employee(employeeName);

                if (created = true) {
                    File file = new File(points + "\\" + employee.getName() + ".txt");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

                            writer.write(enterprise.toString());
                            writer.write(employee.toString());
                            writer.write(employee.checkDelay(reply, enterprise));
                            System.out.println("New point created ");
                            System.out.println();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("ERROR:The file could not be created");
                }
            }
        }
    }
