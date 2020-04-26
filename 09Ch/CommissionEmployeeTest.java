public class CommissionEmployeeTest
{
    public static void main(String[] args)
    {
        CommissionEmployee employee = new CommissionEmployee("Sue", "Jones", "222-22-2222", 10000, .06);

        System.out.println("Employee information obtained by get methods: \n");
        System.out.printf("First name is %s\n", employee.getFirstName());
        System.out.printf("Last name is %s\n", employee.getLastName());
        System.out.printf("Social security number is %s\n", employee.getSocialSecurityNumber());
        System.out.printf("Gross sales is", employee.getGrossSales());
        System.out.printf("Commission rate is %s", employee.getCommissionRate());

        employee.setGrossSales(500);
        employee.setCommissionRate(.1);

        System.out.printf("\nUpdated employee information obtained by toSyring:\n\n%s\n", employee);
    }
}