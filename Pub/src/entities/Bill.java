package entities;

public class Bill {

    private char gender;
    private int beer;
    private int barbecue;
    private int softDrink;

    public Bill() {
    }

    public Bill(char gender, int beer, int barbecue, int softDrink) {
        this.gender = gender;
        this.beer = beer;
        this.barbecue = barbecue;
        this.softDrink = softDrink;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getBeer() {
        return beer;
    }

    public void setBeer(int beer) {
        this.beer = beer;
    }

    public int getBarbecue() {
        return barbecue;
    }

    public void setBarbecue(int barbecue) {
        this.barbecue = barbecue;
    }

    public int getSoftDrink() {
        return softDrink;
    }

    public void setSoftDrink(int softDrink) {
        this.softDrink = softDrink;
    }

    public double cover() {
        return feeding() + ticket() > 30 ? 0.00 : 4.00;
    }

    public double feeding() {
        return (getBeer() * 5.00) + (getSoftDrink() * 3.00) + (getBarbecue() * 7.00);
    }

    public double ticket() {
        return getGender() == 'F' ? 8.00 : 10.00;
    }

    public double total() {
        return feeding() + cover() + ticket();
    }

    @Override
    public String toString() {
        return String.format("""
                        
                        RELATÓRIO:
                        Consumo = R$ %.2f
                        %s
                        Ingresso = R$ %.2f
                        
                        Valor a pagar = R$ %.2f
                        """, feeding(),
                cover() == 0 ? "Isento de Couvert" : String.format("Couvert = R$ %.2f", cover()), ticket(), total());
    }
}
