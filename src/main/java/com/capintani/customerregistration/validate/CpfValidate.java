package com.capintani.customerregistration.validate;

import java.util.function.Predicate;

public class CpfValidate implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return s != null && s.length() == 8 && s.trim().matches("[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}");
    }
}
