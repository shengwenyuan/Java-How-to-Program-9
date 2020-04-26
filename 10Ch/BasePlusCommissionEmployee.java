public class BasePlusCommissionEmployee extends CommissionEmployee
{
    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                                      double grossSales, double commissionRate, double baseSalary)
    {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if(baseSalary >= 0.0)
            this.baseSalary = baseSalary;
        else
            throw new IllegalArgumentException("Base salary must be >= 0.0");
    }

    @Override
    public String toString() {
        return String.format("%s %s; %s: $%, .2f",
                "base-salaried", super.toString(),
                "base salary", getBaseSalary());
    }

    @Override
    public double earnings() {
        return super.earnings() + getBaseSalary();
    }
}
