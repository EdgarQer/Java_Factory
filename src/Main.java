class Animal {
    private String species;
    private String habitat;
    private int legs;

    public Animal(String species, String habitat, int legs) {
        this.species = species;
        this.habitat = habitat;
        this.legs = legs;
    }

    public String getSpecies() {
        return species;
    }

    public String getHabitat() {
        return habitat;
    }

    public int getLegs() {
        return legs;
    }

    @Override
    public String toString() {
        return "Animal(" +
                "species='" + species + '\'' +
                ", habitat='" + habitat + '\'' +
                ", legs=" + legs +
                ')';
    }
}

interface IAnimalBuilder {
    void setSpecies(String species);
    void setHabitat(String habitat);
    void setLegs(int legs);
    Animal build();
}

class AnimalBuilderImplementation implements IAnimalBuilder {
    private String species;
    private String habitat;
    private int legs;

    @Override
    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public void setLegs(int legs) {
        this.legs = legs;
    }

    @Override
    public Animal build() {
        return new Animal(species, habitat, legs);
    }
}

class AnimalDirector {
    private IAnimalBuilder builder;

    public AnimalDirector(IAnimalBuilder builder) {
        this.builder = builder;
    }

    public Animal construct() {
        builder.setSpecies("Lion");
        builder.setHabitat("Savannah");
        builder.setLegs(4);
        return builder.build();
    }
}

public class Main {
    public static void main(String[] args) {
        IAnimalBuilder builder = new AnimalBuilderImplementation();
        AnimalDirector director = new AnimalDirector(builder);
        Animal animal = director.construct();
        System.out.println(animal);
    }
}