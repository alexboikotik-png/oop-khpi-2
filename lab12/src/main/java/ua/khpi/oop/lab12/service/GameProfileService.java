package ua.khpi.oop.lab12.service;

import ua.khpi.oop.lab12.model.Achievement;
import ua.khpi.oop.lab12.model.GameItem;
import ua.khpi.oop.lab12.model.Player;
import ua.khpi.oop.lab12.model.Rarity;

import java.util.*;
import java.util.stream.Collectors;

public class GameProfileService {

    public List<GameItem> getItemsRarity(Player player, Rarity rarity) {
        List<GameItem> result = new ArrayList<>();
        for (GameItem item : player.getInventory()) {
            if (item.getRarity() == rarity) {
                result.add(item);
            }
        }
        return result;
    }

    public List<GameItem> getItemsRarityStream(Player player, Rarity rarity) {
        return player.getInventory().stream()
                .filter(item -> item.getRarity() == rarity)
                .collect(Collectors.toList());
    }

    public List<String> getAchievementTitles(Player player) {
        return player.getAchievements().stream()
                .sorted(Comparator.comparingInt(Achievement::getPoints).reversed())
                .map(Achievement::getTitle)
                .collect(Collectors.toList());
    }

    public double calculateInventory(Player player) {
        return player.getInventory().stream()
                .mapToDouble(GameItem::getValue)
                .sum();
    }

    public long countItemsAboveValue(Player player, double minPrice) {
        return player.getInventory().stream()
                .filter(item -> item.getValue() >= minPrice)
                .count();
    }

    public Map<Rarity, Long> countItemsRarity(Player player) {
        return player.getInventory().stream()
                .collect(Collectors.groupingBy(
                        GameItem::getRarity,
                        Collectors.counting()
                ));
    }
}