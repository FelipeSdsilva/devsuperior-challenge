package entities;

public class TaxPayer {

    private Double salaryIncome;
    private Double servicesIncome;
    private Double capitalIncome;
    private Double healthSpending;
    private Double educationSpending;

    public TaxPayer() {
    }

    public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending, Double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public Double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(Double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public Double getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(Double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public Double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(Double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public Double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(Double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public Double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(Double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public Double salaryTax() {
        if (salaryIncome <= 30000) {
            return 0.0;
        } else if (salaryIncome <= 60000) {
            return salaryIncome * 0.10;
        } else {
            return salaryIncome * 0.20;
        }
    }

    public Double servicesTax() {
        return getServicesIncome() * 0.15;
    }

    public Double capitalTax() {
        return getCapitalIncome() * 0.20;
    }

    public Double grossTax() {
        return salaryTax() + servicesTax() + capitalTax();
    }

    public Double taxRebate() {
        Double totalSpending = healthSpending + educationSpending;
        Double rebate = grossTax() * 0.30;
        if (totalSpending < rebate) {
            return totalSpending;
        } else {
            return rebate;
        }
    }

    public Double netTax() {
        return grossTax() - taxRebate();
    }

    @Override
    public String toString() {
        return String.format(
                "Imposto bruto total: %.2f\n" +
                        "Abatimento: %.2f\n" +
                        "Imposto devido: %.2f",
                grossTax(), taxRebate(), netTax());
    }
}
