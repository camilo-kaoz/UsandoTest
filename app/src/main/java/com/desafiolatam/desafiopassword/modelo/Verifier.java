package com.desafiolatam.desafiopassword.modelo;

import androidx.annotation.VisibleForTesting;

public class Verifier {

    public static final int WEAK_PASS = 1;
    public static final int MEDIUM_PASS = 2;
    public static final int STRONG_PASS = 3;
    public static final int VERY_STRONG_PASS = 4;
    public static final int MIN_LENGH = 5;
    int i;

    @VisibleForTesting
    public boolean minimoCaracter(String password) {

        return password.length() >= MIN_LENGH;

    }

    @VisibleForTesting
    public boolean tieneMayuscula(String password) {

        return !password.toLowerCase().equals(password);

    }

    @VisibleForTesting
    public boolean evaluarNumero(String password) {

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {

                return true;
            }
        }
        return false;

    }

    @VisibleForTesting
    public  int evaluatePass(String password) {
        if (minimoCaracter(password) && tieneMayuscula(password) && evaluarNumero(password))
            return 4;
        else if (minimoCaracter(password) && tieneMayuscula(password) && !evaluarNumero(password))
            return 3;
        else if (minimoCaracter(password) && !tieneMayuscula(password) && !evaluarNumero(password))
            return 2;
        else if (!minimoCaracter(password)) ;
        return 1;

    }
}


