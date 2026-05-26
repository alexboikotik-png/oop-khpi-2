package ua.khpi.oop.lab12.demo;

import ua.khpi.oop.lab12.model.Achievement;
import ua.khpi.oop.lab12.model.GameItem;
import ua.khpi.oop.lab12.model.Player;
import ua.khpi.oop.lab12.model.Rarity;
import ua.khpi.oop.lab12.service.GameProfileService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<GameItem> items = Arrays.asList(
                new GameItem("Зілля життя", Rarity.COMMON, 10.0),
                new GameItem("Дерев'яний щит", Rarity.COMMON, 25.0),
                new GameItem("Сталевий меч", Rarity.RARE, 150.0),
                new GameItem("Плащ невидимості", Rarity.EPIC, 1200.0),
                new GameItem("Палець Сукуни", Rarity.LEGENDARY, 5000.0)
        );

        List<Achievement> achievements = Arrays.asList(
                new Achievement("Перша кров", 10),
                new Achievement("Легенда Арени", 500),
                new Achievement("Дослідник підземель", 50)
        );

        Player player = new Player("Потужний47", items, achievements);
        GameProfileService service = new GameProfileService();
        
        System.out.println("\nПредмети із звичайною рідкісттю");
        service.getItemsRarityStream(player, Rarity.COMMON).forEach(System.out::println);

        System.out.println("\nНазви досягнень");
        service.getAchievementTitles(player).forEach(System.out::println);

        System.out.println("\nВартість інвентарю");
        System.out.println(service.calculateInventory(player) + " монет");

        System.out.println("\nКількість дорогих предметів");
        System.out.println(service.countItemsAboveValue(player, 1000.0) + " шт");

        System.out.println("\nСтатистика предметів за рідкістю");
        service.countItemsRarity(player).forEach((rarity, count) -> System.out.println(rarity + " " + count + " шт"));
 }
}