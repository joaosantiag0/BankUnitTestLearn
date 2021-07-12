package br.com.jsantiago;


import br.com.jsantiago.data.repositories.AccountRepository;
import br.com.jsantiago.exceptions.AccountException;
import br.com.jsantiago.exceptions.ClientNameException;
import br.com.jsantiago.exceptions.CpfInvalidException;
import br.com.jsantiago.models.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final String ABRIR_CONTA = "Abrir conta";
    public static final String SALDO = "Saldo";
    public static final String DEPOSITAR = "Depositar";
    public static final String SACAR = "Sacar";
    public static final String SAIR = "Sair";

    public static AccountRepository accountRepository;

    public static void main(String[] args) {

        while (true)
        try {
                menu();
        } catch (NumberFormatException e) {
            clearScreen();
            System.out.println("Use um dos numeros descritos antes da opcao.");
        } catch (IndexOutOfBoundsException e){
            clearScreen();
            System.out.println("Opcao inexistente.");
        }
    }

    public static void menu() throws NumberFormatException, IndexOutOfBoundsException {
        List<String> menuOptions = new ArrayList<String>() {{
            add(ABRIR_CONTA);
            add(SALDO);
            add(DEPOSITAR);
            add(SACAR);
            add(SAIR);
        }};

        int[] optionIndex = {0};
        Optional<String> optionalOps = menuOptions.stream()
                .map(x -> {
                    optionIndex[0]++;
                    return String.format("  %d) %s \n ", optionIndex[0], x);
                })
                .reduce((x, z) -> x + z);

        System.out.println("Bem vindo ao banco de teste, selecione uma opção:" +
                "\n" + optionalOps.get());

        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.next();

        int userChoice = -1;
        try {
            userChoice = Integer.parseInt(userInput);
        } catch (NumberFormatException exception) {
            throw exception;
        }

        if (userChoice <= 0 || userChoice > menuOptions.size())
            throw new IndexOutOfBoundsException();

        switch (menuOptions.get(userChoice - 1)) {
            case ABRIR_CONTA:
                try {
                    abrirConta();
                } catch (ClientNameException e) {
                    System.out.println("Nescessario nome completo.");
                } catch (CpfInvalidException e){
                    System.out.println("O CPF informado é inválido");
                } catch (AccountException e){
                    if(e.getMessage().equals("Client already have a account"))
                        System.out.println("Ja ha uma conta cadatrada com este CPF");
                    else
                        System.out.println("Ocorreu um erro ao cadastrar a conta");
                }
                break;
            case SALDO:

                break;
            case DEPOSITAR:

                break;
            case SACAR:

                break;
            case SAIR:
                System.exit(0);
                break;
        }
    }

    public static void abrirConta() throws ClientNameException, CpfInvalidException, AccountException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Abrir conta:");
        System.out.println("Digite o nome do titular:");
        String name = scanner.nextLine();

        if (!name.contains(" "))
            throw new ClientNameException("Name not contains space");

        System.out.println("Digite o CPF do titular:");
        String cpfInput = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher m = pattern.matcher(cpfInput);
        StringBuilder cpf = new StringBuilder();
        while (m.find())
            cpf.append(m.group());
        if (cpf.length() != 11)
            throw new CpfInvalidException();

        Account account = Account.newInstance(name, Float.parseFloat(cpf.toString()));
        getAccountRepository().saveAccount(account);
        System.out.println("Conta aberta! Dados:");
        System.out.println(String.format("Conta: %f Agencia: %f", account.getAccountNumber(), account.getAgencyNumber()));
    }


    public static AccountRepository getAccountRepository() {
        if (accountRepository == null)
            accountRepository = new AccountRepository();
        return accountRepository;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
