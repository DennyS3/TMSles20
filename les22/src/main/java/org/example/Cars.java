package org.example;

import java.util.HashMap;
import java.util.Map;

public class Cars {
    private Map<String, String> cars = new HashMap<>();

    public Cars(String id, String param) {
        this.cars.put(id, param);
    }

    public Cars() {
    }

    public String getCars(String id) {
        if (cars.containsKey(id) == true) {
            return cars.get(id);
        } else {
            return "Not car, enter new id";
        }
    }

    public String setCars(String id, String model) {
        if (cars.containsKey(id) == true) {
            this.cars.put(id, model);
            return "update data car: " + cars.get(id);
        } else {
            this.cars.put(id, model);
            return "add new car: " + cars.get(id);
        }
    }

    public String deleteCars(String id) {
        if (cars.containsKey(id) == true) {
            String s = this.cars.get(id);
            this.cars.remove(id);
            return "removed car: " + s;
        } else {
            return "this car is absent";
        }
    }

    public Map<String, String> init() {
        cars.put("0", "Renault");
        cars.put("1", "BMW");
        cars.put("2", "Audi");
        return cars;
    }
}
