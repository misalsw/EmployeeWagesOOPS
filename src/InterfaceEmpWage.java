

abstract class InterfaceEmpWage {

    public abstract void computeWage();

    public interface interfaceEmpWage {
        public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth);
        public void computeWage();
    }
}
