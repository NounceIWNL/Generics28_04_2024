package com.company.databases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class InventoryGenerate {
    public static void main(String[] args) {
        //C:\Users\gk\IdeaProjects\Generic\src\com\company\databases

        Random random = new Random();
        Path fileName = Path.of("src/com/company/databases/inventoryGen.sql");
        for (int i = 0; i < 1000; i++) {
            int character = random.nextInt(35) + 2;
            int item = random.nextInt(92) + 1;
            String query =
                    String.format("insert into inventory(character_id, item_id) values (%d,%d);%n", character, item);
            try {
                Files.writeString(fileName, query, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
