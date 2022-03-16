public class CompanyEmpWage {

    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    public final String company;
    public final int empRatePerHour;
    public final int numOfWorkingDays;
    public final int maxHoursPerMonth;
    public int totalWage;

    public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;

    }

    public void setTotalEmpWage(int totalWage) {
        this.totalWage = totalWage;
    }

    @Override
    public String toString() {
        return "Total Emp Wage for company: " + company + " is :" + totalWage;
    }
}
