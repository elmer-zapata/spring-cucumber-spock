package com.example.accessingmongodbdatarest.cliente;

import org.springframework.data.annotation.Id;

public class Client {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String targetNumber;
    private String beneficiary;

    public String getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(String targetNumber) {
        this.targetNumber = targetNumber;
    }

    public String getBenefict() {
        return beneficiary;
    }

    public void setBenefict(String benefict) {
        this.beneficiary = benefict;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
