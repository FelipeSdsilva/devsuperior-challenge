package entities;

public class Champion {

    private String name;
    private Integer life;
    private Integer attack;
    private Integer armor;

    public Champion() {
    }

    public Champion(String name, Integer life, Integer attack, Integer armor) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getArmor() {
        return armor;
    }

    public void setArmor(Integer armor) {
        this.armor = armor;
    }

    public void takeDamage(Champion champion) {
        int damage = champion.attack - this.armor;
        damage = Math.max(damage, 1);
        this.life = Math.max(this.life - damage, 0);

    }

    public String status() {
        return this.life > 0 ? String.format("\n%s: %d de vida", name, life) : String.format("\n%s: 0 de vida (morreu)", name);
    }
}
