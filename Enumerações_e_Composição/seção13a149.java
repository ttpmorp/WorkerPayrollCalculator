package Enumerações_e_Composição;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HoursContract;
import entities.Worker;
import entities.enums.WorkerLevel;
public class seção13a149 {

	public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Correção no formato da data

        System.out.print("Enter department's name: ");
        String departmentname = sc.nextLine();

        System.out.println("Enter worker data: "); // Correção no texto da saída
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Level: ");
        String level = sc.nextLine();

        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(departmentname));

        System.out.print("How many contracts to this worker? ");
        int contracts = sc.nextInt();

        for (int i = 1; i <= contracts; i++) {
            System.out.printf("Enter contract #%d data:\n", i); // Correção na saída
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble(); // Alterado para double

            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            HoursContract contract = new HoursContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        
        System.out.println("Name: " + worker.getName()); // Correção na formatação da saída
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.printf("Income for %.2f: ", worker.income(year, month));

        sc.close();
    }
}