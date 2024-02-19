package com.example.propz.services;

import com.example.propz.utils.ResponseFormat;
import com.example.propz.validators.ProblemValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProblemService {

    @Autowired
    private ProblemValidators validators;

    public ResponseFormat<String> isPerfectNumber(int number) {
        try {
            validators.validateNumberInput(number);
            int sum = 0;
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    sum += i;
                }
            }
            boolean isPerfect = sum == number;
            String message = isPerfect ? "O número " + number + " é perfeito." : "O número " + number + " não é perfeito.";
            return new ResponseFormat<>(200, message, "Sucesso.");
        } catch (Exception e) {
            return new ResponseFormat<>(500, null, e.getMessage());
        }
    }

    public ResponseFormat<List<Integer>> findPerfectNumbers(int start, int end) {
        try {
            validators.validateInterval(start, end);
            List<Integer> perfectNumbers = new ArrayList<>();
            for (int number = start; number <= end; number++) {
                if (isPerfectNumber(number).getData().equals("O número " + number + " é perfeito.")) {
                    perfectNumbers.add(number);
                }
            }
            String message = perfectNumbers.isEmpty() ? "Nenhum número perfeito encontrado no intervalo fornecido." : "Números perfeitos encontrados no intervalo fornecido.";
            return new ResponseFormat<>(200, perfectNumbers, message);
        } catch (Exception e) {
            return new ResponseFormat<>(500, null, e.getMessage());
        }
    }
}
