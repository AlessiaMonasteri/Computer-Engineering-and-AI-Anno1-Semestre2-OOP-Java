package house.generics;

public class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean hasGarage;
    private boolean hasSwimmingPool;
    private boolean hasGarden;

    /*getters and setters */
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

    /*string output*/
    @Override
    public String toString() {
        return "House with " + foundation + ", " + structure + " and " + roof +
            (hasGarage ? ", Garage" : "") +
            (hasSwimmingPool ? ", Swimming Pool" : "") +
            (hasGarden ? ", Garden" : "");
    }

    /*DEFINIZIONE DELL'HOUSE BUILDER*/
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

    /*i parametri obbligatori sono definiti in un costruttore pubblico*/
    public HouseBuilder(String foundation, String structure, String roof) {
        this.foundation = foundation;
        this.structure = structure;
        this.roof = roof;
        }

    /*metodo build che deve essere sempre chiamato di default */
    public House build() {
        return new House(this);
        }
       
    // Optional parameters with default values
        private boolean hasGarage = false;
        private boolean hasSwimmingPool = false;
        private boolean hasGarden = false;

    /*i 3 parametri opzionali sono definiti in 3 costruttori pubblici*/
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
   
   
