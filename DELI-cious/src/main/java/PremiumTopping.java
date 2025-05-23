public class PremiumTopping extends Topping{


    public PremiumTopping(String name, boolean isExtra) {
        super(name, isExtra);
    }

    public double price1(){
        double price = 0;
        if (getName().trim().equalsIgnoreCase("American") || getName().trim().equalsIgnoreCase("Provolone")
                || getName().trim().equalsIgnoreCase("Cheddar") || getName().trim().equalsIgnoreCase("swiss")){
            price = 0.75;
        } else {
            price = 1.00;
        }
        return price;
    }

    public double price2(){
        double price = 0;
        if (getName().trim().equalsIgnoreCase("American") || getName().trim().equalsIgnoreCase("Provolone")
                || getName().trim().equalsIgnoreCase("Cheddar") || getName().trim().equalsIgnoreCase("swiss")){
            price = 1.50;
        } else {
            price = 2.00;
        }
        return price;
    }

    public double price3(){
        double price = 0;
        if (getName().trim().equalsIgnoreCase("American") || getName().trim().equalsIgnoreCase("Provolone")
                || getName().trim().equalsIgnoreCase("Cheddar") || getName().trim().equalsIgnoreCase("swiss")){
            price = 2.25;
        } else {
            price = 3.00;
        }
        return price;
    }

        @Override
        public double getPrice () {
        ;if (isExtra()){
            return price1() + price2() + price3();
            }
        return 0;
    }

}
