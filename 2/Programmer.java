public class Programmer extends Employee {
    protected String primarySkill;
    protected String favoriteLanguage;
    protected int level;

    public Programmer(String name, int id, double salary, String primarySkill, String favoriteLanguage, int level) {
        super(name, id, salary);
        this.primarySkill = primarySkill;
        this.favoriteLanguage = favoriteLanguage;
        this.level = level;
    }

    public Programmer() {
        super();
        this.primarySkill = "Java";
        this.favoriteLanguage = "Java";
        this.level = 1;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public int getLevel() {
        return level;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public void setBudget(int level) {
        this.level = level;
    }

    @Override
    public void work() {
        System.out.println("Программист " + name + " пишет код на " + favoriteLanguage );
    }

    @Override
    public String getRole() {
        return "Программист";
    }

    public void codeWritten () {
        System.out.println("Программист решает сложную задачу");
    }
}
