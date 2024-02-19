package com.example.propz.controllers;

import com.example.propz.services.ProblemService;
import com.example.propz.utils.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;


    @GetMapping("/check-perfect/{number}")
    public ResponseFormat<String> checkPerfectNumber(@PathVariable int number) {
        return problemService.isPerfectNumber(number);
    }

    @GetMapping("/find-perfect")
    public ResponseFormat<List<Integer>> findPerfectNumbers(@RequestParam int start, @RequestParam int end) {
        return problemService.findPerfectNumbers(start, end);
    }
}
