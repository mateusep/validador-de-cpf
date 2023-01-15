package verificadordecpf;

import java.util.Scanner;

public class CPFValidatorWithScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de CPF: ");
        String cpf = scanner.nextLine();
        if (CPFValidator.isValidCPF(cpf)) {
            System.out.println("CPF válido");
        } else {
            System.out.println("CPF inválido");
        }
        scanner.close();
    }
}
