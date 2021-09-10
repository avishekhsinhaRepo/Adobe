package com.training.core.config;

public interface TrainingOSGiConfig {
    public String getServiceName();

    public int getServiceCount();

    public boolean isLiveData();

    public String[] getCountries();

    public String getRunModes();
}
