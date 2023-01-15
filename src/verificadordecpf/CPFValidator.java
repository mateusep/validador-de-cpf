package verificadordecpf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPFValidator {
    public static boolean isValidCPF(String cpf) {
        // Remover pontuação
        cpf = cpf.replaceAll("[^0-9]", "");
        // Verifica se o número de digitos é igual a 11
        if (cpf.length() != 11) {
            return false;
        }
        // Verifica se todos os dígitos são iguais
        if (cpf.matches("^(\\d)\\1+$")) {
            return false;
        }
        // Cálculo do primeiro dígito verificador
        int d1 = 0;
        for (int i = 0; i < 9; i++) {
            d1 += (10 - i) * Character.getNumericValue(cpf.charAt(i));
        }
        d1 = 11 - (d1 % 11);
        if (d1 > 9) {
            d1 = 0;
        }
        // Cálculo do segundo dígito verificador
        int d2 = 0;
        for (int i = 0; i < 10; i++) {
            d2 += (11 - i) * Character.getNumericValue(cpf.charAt(i));
        }
        d2 = 11 - (d2 % 11);
        if (d2 > 9) {
            d2 = 0;
        }
        // Verifica se os dígitos verificadores calculados são iguais aos dígitos verificadores do número de CPF
        return d1 == Character.getNumericValue(cpf.charAt(9))
                && d2 == Character.getNumericValue(cpf.charAt(10));
    }

}
