package br.com.jsantiago.models;

import java.util.Random;

public class Account {
    private String name;
    private float cpf;
    private float accountNumber;
    private float agencyNumber;
    private float amount;

    public static Account newInstance(String name, float cpf){
        Random random = new Random();
        Account account = new Account();
        account.name = name;
        account.cpf = cpf;
        account.accountNumber = random.nextInt(999999999);
        account.agencyNumber = random.nextInt(99999);
        account.amount = 0f;
        return account;
    }

    public float getAgencyNumber() {
        return agencyNumber;
    }

    public String getName() {
        return name;
    }

    public float getCpf() {
        return cpf;
    }

    public float getAccountNumber() {
        return accountNumber;
    }

    public float getAmount() {
        return amount;
    }
}
