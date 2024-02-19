package com.example.propz.validators;

import org.springframework.stereotype.Component;

@Component
public class ProblemValidators {

    public void validateNumberInput(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("O número fornecido deve ser positivo e diferente de zero.");
        }
    }

    public void validateInterval(int start, int end) {
        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("Os números do intervalo fornecido devem ser positivos.");
        }
        if (start >= end) {
            throw new IllegalArgumentException("O início do intervalo deve ser menor que o final do intervalo.");
        }
    }
}
