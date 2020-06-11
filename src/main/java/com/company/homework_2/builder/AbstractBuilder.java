package com.company.homework_2.builder;

import com.company.homework_2.util.BundleUtil;

import java.util.Map;

public interface AbstractBuilder {

    default Map<String, String> getKeyValueMapByBundleProperties(String lang) {
        return BundleUtil.getBundleProperties(lang);
    }

    void buildDataList();
}
