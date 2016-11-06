package net.bluemoon.bankingpro.utils;

/**
 * Created by mvnpavan on 23/01/16.
 */
public enum  BankingType {

    Mobile(1) , Desktop(2);

    private int bankingType;

    private BankingType(int bankingType){
        this.bankingType = bankingType;
    }

    public int getBankingType(){
        return bankingType;
    }
}
