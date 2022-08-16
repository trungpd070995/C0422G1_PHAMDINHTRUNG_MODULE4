package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {

    @Override
    public String result(String number1, String number2, String calculator) {
        try {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            double result = 0;
            switch (calculator) {
                case "Addition":
                    result = num1 + num2;
                    break;
                case "Subtraction":
                    result = num1 - num2;
                    break;
                case "Multiplication":
                    result = num1 * num2;
                    break;
                case "Division":
                    if (num2 == 0) {
                        return "Không chia được !";
                    }
                    result = num1 / num2;
                    break;
            }
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            return "Chỉ nhập số ! Không được nhập chữ";
        }
    }
}
