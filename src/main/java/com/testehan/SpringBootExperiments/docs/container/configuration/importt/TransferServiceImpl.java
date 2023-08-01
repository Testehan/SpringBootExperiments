package com.testehan.SpringBootExperiments.docs.container.configuration.importt;

public class TransferServiceImpl implements TransferService{

    private final AccountRepository accountRepository;

    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void transfer(double ammount, String fromAccount, String toAccount) {
        accountRepository.print();
        System.out.println("Transfering " + ammount + " from " + fromAccount + " to " + toAccount);
    }
}
