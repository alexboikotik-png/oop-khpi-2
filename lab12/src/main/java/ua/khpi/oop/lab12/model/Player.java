package ua.khpi.oop.lab12.model;

import java.util.List;

public class Player {
    private String nickname;
    private List<GameItem> inventory;
    private List<Achievement> achievements;

    public Player(String nickname, List<GameItem> inventory, List<Achievement> achievements) {
        this.nickname = nickname;
        this.inventory = inventory;
        this.achievements = achievements;
    }

    public String getNickname() { return nickname; }
    public List<GameItem> getInventory() { return inventory; }
    public List<Achievement> getAchievements() { return achievements; }
}