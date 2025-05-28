package org.example;

import java.util.HashMap;
import java.util.Map;

public class CoffeMachine {
    private final Map<String, Coffe> coffes = new HashMap<>();
    private boolean powerOn = true;
    private boolean maintenanceMode = false;
    private boolean waterAvailable = true;
    private boolean authorized = true;

    public CoffeMachine() {
        coffes.put("latte", new Coffe("Latte", 2.5, 5));
        coffes.put("espresso", new Coffe("Espresso", 2.0, 5));
        coffes.put("cappuccino", new Coffe("Cappuccino", 3.0, 5));
    }

    public String selectCoffee(String type, Money money) {
        if (!authorized) return "⚠️ c7: Unauthorized";
        if (maintenanceMode) return "⚠️ c6: Maintenance";
        if (!powerOn) return "⚠️ c3: Power outage";
        if (!waterAvailable) return "⚠️ c4: No water";

        Coffe selected = coffees.get(type.toLowerCase());
        if (selected == null) return "⚠️ c5: Invalid type";
        if (!selected.isAvailable()) return "⚠️ c2: Out of coffee";
        if (!money.withdraw(selected.getPrice())) return "⚠️ c1: Not enough funds";

        boolean paid = money.withdraw(selected.getPrice());
        if (!paid) return "⚠️ c1: Not enough funds";

        selected.decrementQuantity();
        return "✅ Preparing your " + selected.getName() + "... Enjoy!";
    }

    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    public void setMaintenanceMode(boolean maintenanceMode) {
        this.maintenanceMode = maintenanceMode;
    }

    public void setWaterAvailable(boolean waterAvailable) {
        this.waterAvailable = waterAvailable;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }
}
