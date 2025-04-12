package house.generics;

public class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean hasGarage;
    private boolean hasSwimmingPool;
    private boolean hasGarden;

    public String getFoundation() {
        return foundation;
    }
    
    public String getStructure() {
        return structure;
    }
    
    public String getRoof() {
        return roof;
    }
    
    public boolean hasGarage() {
        return hasGarage;
    }
    
    public boolean hasSwimmingPool() {
        return hasSwimmingPool;
    }
    
    public boolean hasGarden() {
        return hasGarden;
    }

    @Override
    public String toString() {
        return "House with " + foundation + ", " + structure + " and " + roof +
            (hasGarage ? ", Garage" : "") +
            (hasSwimmingPool ? ", Swimming Pool" : "") +
            (hasGarden ? ", Garden" : "");
    }

    private House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.roof = builder.roof;
        this.hasGarage = builder.hasGarage;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.hasGarden = builder.hasGarden;
    }

    public static class HouseBuilder {
        // Required parameters
        private String foundation;
        private String structure;
        private String roof;

    public HouseBuilder(String foundation, String structure, String roof) {
        this.foundation = foundation;
        this.structure = structure;
        this.roof = roof;
        }

    public House build() {
        return new House(this);
        }
       
 // Optional parameters with default values
    private boolean hasGarage = false;
    private boolean hasSwimmingPool = false;
    private boolean hasGarden = false;

    public HouseBuilder setGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
        return this;
    }
    public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
        this.hasSwimmingPool = hasSwimmingPool;
        return this;
    }
    public HouseBuilder setGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
        return this;
    }
 }

}
   
   
