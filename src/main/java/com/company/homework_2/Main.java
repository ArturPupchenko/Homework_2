package com.company.homework_2;

import com.company.homework_2.builder.DataBuilder;
import com.company.homework_2.config.ApplicationEnvironment;

public class Main {

    public static void main(String[] args){
        runDataBuilder(args);
    }

    private static  void runDataBuilder(String[] args) {
        DataBuilder dataBuilder = new DataBuilder();
        if (args.length != 0) {
            ApplicationEnvironment.setPropertyLang(args[0]);
        } else {
            ApplicationEnvironment.setPropertyLang("en");
        }
        dataBuilder.buildDataList();
    }
}
