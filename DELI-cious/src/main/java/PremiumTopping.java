public class PremiumTopping extends Topping{
    private int sandwichSize;

    public PremiumTopping(String name, boolean isExtra, int sandwichSize) {
        super(name, isExtra);
        this.sandwichSize = sandwichSize;
    }

    public int getSandwichSize() {
        return sandwichSize;
    }

    public boolean isMeat(){
        boolean isMeat = false;
        if( getName().equalsIgnoreCase("Steak") ||
                getName().equalsIgnoreCase("Ham") ||
                getName().equalsIgnoreCase("Salami") ||
                getName().equalsIgnoreCase("Roast Beef") ||
                getName().equalsIgnoreCase("Chicken") ||
                getName().equalsIgnoreCase("Bacon")){
                    isMeat = true;
        }
        return isMeat;
    }

    @Override
        public double getPrice () {
        return 0;
        }
}
