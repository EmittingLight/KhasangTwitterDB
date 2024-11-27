package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteConnection {
    public static void main(String[] args) {
        // Путь к базе данных
        String url = "jdbc:sqlite:src/main/resources/twitter.db"; // Обновите путь к вашей базе

        // Пробуем подключиться
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Подключение к базе данных установлено!");

                // Пример выполнения запроса
                String query = "SELECT * FROM users";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                // Вывод данных
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " | " +
                            rs.getString("username") + " | " +
                            rs.getString("full_name"));
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка подключения к базе данных: " + e.getMessage());
        }
    }
}

