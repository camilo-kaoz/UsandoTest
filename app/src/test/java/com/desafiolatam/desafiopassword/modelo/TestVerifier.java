package com.desafiolatam.desafiopassword.modelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestVerifier {

    private Verifier verifier;
    @Before
    public void setUp(){
        verifier = new Verifier();
    }

    @Test
    public void evaluacionMinimoDeCaracteres_ok(){
        String password = "asdkjfg";
      assertTrue(verifier.minimoCaracter(password));

    }
    @Test
    public void menosDeLoRequerido (){

        String password = "as";
        assertFalse(verifier.minimoCaracter(password));
    }
    @Test
    public void llevaMayuscula (){

        String password = "LASDsad";
        assertTrue(verifier.tieneMayuscula(password));
}
    @Test
    public void noLLevaMayuscula (){

        String password = "jhgsad";
        assertFalse(verifier.tieneMayuscula(password));
    }

    @Test
    public void tieneNumero (){

        String password = "jbjj2";
        assertTrue(verifier.evaluarNumero(password));
    }

    @Test
    public void noTieneNumero (){

        String password ="asdaf";
        assertFalse(verifier.evaluarNumero(password));
    }
    @Test
    public void evaluatePass_weak() {
        String password = "abc";
        int eval = verifier.evaluatePass(password);
        assertEquals(eval, Verifier.WEAK_PASS);
    }

    @Test
    public void evaluatePass_medium() {
        String password = "abcde";
        int eval = verifier.evaluatePass(password);
        assertEquals(eval, Verifier.MEDIUM_PASS);
    }

    @Test
    public void evaluatePass_strong() {
        String password = "Abcde";
        int eval = verifier.evaluatePass(password);
        assertEquals(eval, Verifier.STRONG_PASS);
    }

    @Test
    public void evaluatePass_very_strong() {
        String password = "Abcde1";
        int eval = verifier.evaluatePass(password);
        assertEquals(eval, Verifier.VERY_STRONG_PASS);
    }
}
