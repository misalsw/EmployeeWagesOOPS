import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmpWage implements InterfaceEmpWage {
    // declaring static variables
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;
    // using Array List
    private ArrayList<CompanyEmpWage> companyEmpArrayList;
    private Map<String, CompanyEmpWage> companyToEmpWageMap;
    // using constructor
    public EmpWage() {
        companyEmpArrayList = new ArrayList<CompanyEmpWage>();
        companyToEmpWageMap = new HashMap<>();
    }

    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {

        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
        companyEmpArrayList.add(companyEmpWage);
        companyToEmpWageMap.put(company, companyEmpWage);
    }

    public void computeEmpWage() {
        for (int i = 0; i < companyEmpArrayList.size(); i++) {
            CompanyEmpWage companyEmpwage = companyEmpArrayList.get(i);
            companyEmpwage.setTotalEmpWage(this.computeEmpWage(companyEmpwage));
            System.out.println("Company Name: " + companyEmpwage.company);
            DisplayDailyWageforCompany(companyEmpwage);
            System.out.println(companyEmpwage.company + "Total Wage is " + companyEmpwage.totalWage);
        }
    }

    public void DisplayDailyWageforCompany(CompanyEmpWage companyEmpwage) {
        for (int i = 0; i < companyEmpwage.empDailyWage.size(); i++) {
            int day = i + 1;
            System.out.println("Daily Wage For Day" + day + ":" + companyEmpwage.empDailyWage.get(i));
        }
    }

    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        // variables
        int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
        // computation
        while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {

            totalWorkingDays++;

            int empCheck = (int) (Math.random() * 10) % 3;
            // using switch statement to check the employee working time
            switch (empCheck) {

                case IS_FULL_TIME:
                    empHrs = 8;
                    System.out.println("Employee is present as Full time");
                    break;
                case IS_PART_TIME:

                    empHrs = 4;
                    System.out.println("Employee is working as part time");
                    break;
                default:
                    empHrs = 0;
                    System.out.println("Employee is Absent");
            }
            totalEmpHrs += empHrs;
            System.out.println("Day#" + totalWorkingDays + "Emp Hr:" + empHrs);
        }
        // calculating total Employee wage for company
        return totalEmpHrs * companyEmpWage.empRatePerHour;

    }

    public static void main(String args[]) {

        System.out.println("Welcome to Employee Wage calculation");
        EmpWage empwage = new EmpWage();
        empwage.addCompanyEmpWage("Dmart", 20, 2, 10);
        empwage.addCompanyEmpWage(" BIGBAZAR ", 5, 25, 25);
        empwage.computeEmpWage();
    }

    @Override
    public void computeWage() {
        for (int i = 0; i < companyEmpArrayList.size(); i++) {
            CompanyEmpWage companyEmpWage = companyEmpArrayList.get(i);
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
            System.out.println("Company Name : " + companyEmpWage.company);
            DisplayDailyWageforCompany(companyEmpWage);
            System.out.println("Total Wage is:" + companyEmpWage.totalWage);
        }

}

    @Override
    public int getTotalWage(String company) {
            return companyToEmpWageMap.get(company).totalWage;
    }
}
