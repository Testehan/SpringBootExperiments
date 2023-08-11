package com.testehan.SpringBootExperiments.docs.container.configuration.importt;

public class TransferImportServiceImpl implements TransferImportService{

    private final AccountRepository accountRepository;

    public TransferImportServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void transfer(double ammount, String fromAccount, String toAccount) {
        accountRepository.print();
        System.out.println("Transfering " + ammount + " from " + fromAccount + " to " + toAccount);
    }
}
