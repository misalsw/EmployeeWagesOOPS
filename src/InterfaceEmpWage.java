

public interface InterfaceEmpWage {
    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth);

    public void computeWage();

    int getTotalWage(String company);
}