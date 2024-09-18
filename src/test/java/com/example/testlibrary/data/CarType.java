package com.example.testlibrary.data;

public enum CarType {


    CITROEN_C3() {
        @Override
        public Car getInfo() {
            Car car = new Car();
            car.setVehicleType("Otomobil");
            car.setBrand("Citroen");
            car.setModel("C3");
            car.setFuel("Benzin");
            car.setBodyType("Hatchback 5 kapı");
            car.setSubModel("1.2 PureTech");
            car.setSubCategory("Live");
            car.setFullModelName("C3 1.2 PureTech Live EAT6");
            car.setKm("40000");
            return car;
        }
    };



    public abstract Car getInfo();
}
