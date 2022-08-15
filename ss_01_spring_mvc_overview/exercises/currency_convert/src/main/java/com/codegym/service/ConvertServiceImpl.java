package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements IConvertService{
    @Override
    public double value(double usd) {
        return usd * 23000;
    }
}
