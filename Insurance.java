public class Insurance {
    private String insuranceID;
    private String providerName;
    private String PolicyNumber;
    private String ExpiryDate;
    private double insuranceCost;
    private String coverageDetails;

    public Insurance(String insuranceID, String providerName, String policyNumber, String expiryDate, double insuranceCost, String coverageDetails) {
        this.insuranceID = insuranceID;
        this.providerName = providerName;
        PolicyNumber = policyNumber;
        ExpiryDate = expiryDate;
        this.insuranceCost = insuranceCost;
        this.coverageDetails = coverageDetails;
    }

    public String getInsuranceID() { return insuranceID; }
    public String getProviderName() { return providerName; }
    public String getPolicyNumber() { return PolicyNumber; }
    public String getExpiryDate() { return ExpiryDate; }
    public double getInsuranceCost() { return insuranceCost; }
    public String getCoverageDetails() { return coverageDetails; }

    public void setInsuranceID(String insuranceID) { this.insuranceID = insuranceID; }
    public void setProviderName(String providerName) { this.providerName = providerName; }
    public void setPolicyNumber(String policyNumber) { this.PolicyNumber = policyNumber; }
    public void setExpiryDate(String expiryDate) { this.ExpiryDate = expiryDate; }
    public void setInsuranceCost(double insuranceCost) { this.insuranceCost = insuranceCost; }
    public void setCoverageDetails(String coverageDetails) { this.coverageDetails = coverageDetails; }

    public void checkCoverage(){
        System.out.println("Coverage Details: " + coverageDetails);
    }

    public void displayInsuranceDetails(){
        System.out.println("Insurance Details: ");
        System.out.println("Insurance ID: " + insuranceID);
        System.out.println("Provider Name: " + providerName);
        System.out.println("Policy Number: " + PolicyNumber);
        System.out.println("Expiry Date: " + ExpiryDate);
        checkCoverage();
        System.out.println("Insurance Cost: " + insuranceCost);
    }

}
