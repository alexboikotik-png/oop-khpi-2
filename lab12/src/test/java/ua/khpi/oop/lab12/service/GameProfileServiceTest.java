package ua.khpi.oop.lab12.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab12.model.Achievement;
import ua.khpi.oop.lab12.model.GameItem;
import ua.khpi.oop.lab12.model.Player;
import ua.khpi.oop.lab12.model.Rarity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameProfileServiceTest {

    private Player player;
    private GameProfileService service;

    @BeforeEach
    void setUp() {
        List<GameItem> items = Arrays.asList(
                new GameItem("Item1", Rarity.COMMON, 10),
                new GameItem("Item2", Rarity.RARE, 50),
                new GameItem("Item3", Rarity.COMMON, 20)
        );
        List<Achievement> achievements = Arrays.asList(
                new Achievement("Ach1", 10),
                new Achievement("Ach2", 100)
        );
        player = new Player("TestUser", items, achievements);
        service = new GameProfileService();
    }

    @Test
    void test_Items_Rarity_Stream() {
        List<GameItem> commonItems = service.getItemsRarityStream(player, Rarity.COMMON);
        assertEquals(2, commonItems.size());
    }

    @Test
    void test_Calculate_Total_Inventory_Value() {
        assertEquals(80.0, service.calculateInventory(player));
    }

    @Test
    void test_Count_Items_Rarity() {
        Map<Rarity, Long> counts = service.countItemsRarity(player);
        assertEquals(2L, counts.get(Rarity.COMMON));
        assertEquals(1L, counts.get(Rarity.RARE));
    }
}