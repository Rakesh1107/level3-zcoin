package base;

public class ObjectCreator {

    static Customer createCustomer(String fullName, String emailId, long mobileNumber ,int hId, String password, long initialDeposit) {
        Customer customer = new Customer(hId);

        customer.setFullName(fullName);
        customer.setEmailId(emailId);
        customer.setMobileNumber(mobileNumber);
        customer.sethID(hId);
        customer.setPassword(password);
        customer.setBalance(initialDeposit);

        return customer;
    }
}
