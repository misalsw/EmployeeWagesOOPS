public class Main {
    //Constants
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    public static int computeEmpWage(String company, int empRatePerHour,
                                     int numOfWorkingDays, int maxHoursPerMonth) {
        // Class Members(variables)
        int empHours = 0;
        int totalEmpHour = 0;
        int totalEmpDay = 0;
        int dailyWage = 0;
        //Computation
        while (totalEmpHour <= maxHoursPerMonth && totalEmpDay <= numOfWorkingDays) {
            totalEmpDay++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch ((int) empCheck) {
                case IS_FULL_TIME:
                    empHours = 8;
                    break;
                case IS_PART_TIME:
                    empHours = 4;
                    break;
                default:
                    empHours = 0;
            }
            totalEmpHour += empHours;
            dailyWage = empHours * empRatePerHour;
            System.out.println("Day#: " + totalEmpDay + "Emp hour: " + empHours + ", Daily Wage: " + dailyWage );
        }
        int totalEmpWage = totalEmpHour * empRatePerHour;
        System.out.println("Total Emp Wage for the Company: " + company + " is :" + totalEmpWage + "\n");
        return totalEmpWage;
    }

    public static void main(String[] args) {
        computeEmpWage("DMart", 20, 2, 10);
        computeEmpWage("Reliance", 40, 10, 20);
    }
}
