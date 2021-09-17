package be.upgrade.it.engineering.refactoring;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GildedRoseTest {
    @Test
    public void golden_master() throws Exception {
        PrintStream stream = new PrintStream(new BufferedOutputStream(new FileOutputStream("output.txt")));
        System.setOut(stream);
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 13) };

        GildedRose app = new GildedRose(items);

        int days = 100;

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
        stream.close();

        List<String> actual = Files.readAllLines(Paths.get("output.txt"));
        List<String> goldenMaster = Files.readAllLines(Paths.get("golden-master.txt"));
        assertThat(actual.toArray()).containsExactly(goldenMaster.toArray());
    }

}