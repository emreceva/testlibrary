package com.example.testlibrary.interfaces.sahibinden;

import com.example.testlibrary.data.CarType;

public interface SahibindenVehiclePriceEvaluation {

    boolean isAt();

    SahibindenVehiclePriceEvaluation clickVehickeEvaluationButton();

    SahibindenVehiclePriceEvaluation clickVehicleTypeSelectionContainer();

    SahibindenVehiclePriceEvaluation clickEvaluateAnotherVehicleButton();

    SahibindenVehiclePriceEvaluation goToVehicleEvaluationPage();

    SahibindenVehiclePriceEvaluation selectCarOnContainer(CarType carType);

}
