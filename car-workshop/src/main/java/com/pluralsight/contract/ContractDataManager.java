package com.pluralsight.contract;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ContractDataManager {
    private ArrayList<Contract> contracts = new ArrayList<>();

    public void initContracts() {
        contracts = new ContractFileManager().readFromFile();
    }

    public void saveContract(Contract contract) {

        contracts.add(contract);
        new ContractFileManager().saveToFile(contract.toString());
    }

    public List<Contract> getAllContracts() {
        return contracts.stream().sorted(Comparator.comparing(Contract::getDate).reversed()).toList();
    }

    public List<Contract> getLastTenContracts() {
       List<Contract> returnValue = new ArrayList<>();

        if(contracts.size() < 10){
           return contracts;
       }
       else{
           for (int i = 0 ; i < 10; i++) {
               returnValue.add(contracts.get(contracts.size() - 1 - (i)));
           }
       }
       return returnValue.stream().sorted(Comparator.comparing(Contract::getDate).reversed()).toList();
    }


}
