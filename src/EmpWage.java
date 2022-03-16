import java.util.ArrayList;

public class EmpWage extends InterfaceEmpWage {
    // declaring static variables
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    private ArrayList<CompanyEmpWage> companyEmpWageArrayList;

    public EmpWage() {
        companyEmpWageArrayList = new  ArrayList<CompanyEmpWage>();
    }
    private void  addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {

        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
        companyEmpWageArrayList.add(companyEmpWage);
    }

    private void computeEmpWage() {
        for(int i=0; i < companyEmpWageArrayList.size(); i++) {
                CompanyEmpWage companyEmpWage = companyEmpWageArrayList.get(i);
                companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
            System.out.println(companyEmpWage.company + "Total Wage is " + companyEmpWage.totalWage);

        }
    }
    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        // variables
        int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
        // computation
        while (totalEmpHrs <=companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {

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
        empwage.addCompanyEmpWage("Dmart", 20, 8, 10);
        empwage.computeEmpWage();
        empwage.addCompanyEmpWage(" BIGBAZAR ", 5, 25, 25);
        empwage.computeEmpWage();
    }
   @Override
   public void computeWage(){

   }

}
