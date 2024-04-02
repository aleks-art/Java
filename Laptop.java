import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Laptop {
    private String brand;
    private int ram;
    private int hardDiskSize;
    private String os;
    private String color;

    public Laptop(String brand, int ram, int hardDiskSize, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.hardDiskSize = hardDiskSize;
        this.os = os;
        this.color = color;
    }


    private String getOs() {
        return os;
    }

    private String getColor() {
        return color;
    }

    private Integer getRam() {
        return ram;
    }

    private Integer getHardDiskSize() {
        return hardDiskSize;
    }

    // Метод фильтрации
    public static List<Laptop> filterLaptops(List<Laptop> laptops, Map<Integer, String> criteria) {
        List<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptop : laptops) {
            boolean matchesCriteria = true;
            for (Entry<Integer, String> entry : criteria.entrySet()) {
                switch (entry.getKey()) {
                    case 1: // ОЗУ
                        if (laptop.getRam().equals(entry.getValue())) {
                            matchesCriteria = false;
                            break;
                        }
                        break;
                    case 2: // Объем ЖД
                        if (laptop.getHardDiskSize().equals(entry.getValue())) {
                            matchesCriteria = false;
                            break;
                        }
                        break;
                    case 3: // Операционная система
                        if (!laptop.getOs().equals(entry.getValue().toString())) {
                            matchesCriteria = false;
                            break;
                        }
                        break;
                    case 4: // Цвет
                        if (!laptop.getColor().equals(entry.getValue().toString())) {
                            matchesCriteria = false;
                            break;
                        }
                        break;
                    default:
                        System.out.println("Неизвестный критерий фильтрации");
                        break;
                }
                if (!matchesCriteria) {
                    break;
                }
            }
            if (matchesCriteria) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }
    public String toString() {
        return "Модель: " + brand + ", ОС: " + os + ", RAM: " + ram + "GB, HDD: " + hardDiskSize + "GB, Цвет: " + color;
    }


    // Пример использования
    public static void main(String[] args) {
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("Apple", 8, 256, "macOS", "Silver"));
        laptops.add(new Laptop("Lenovo", 4, 128, "Windows", "Black"));
        laptops.add(new Laptop("HP", 16, 512, "Windows", "Gray"));
        laptops.add(new Laptop("Asus", 8, 256, "Windows", "Blue"));

        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "8"); 
        criteria.put(2, "256"); 
        criteria.put(3,"macOS"); 
        criteria.put(4, "Blue"); 

        List<Laptop> filteredLaptops = filterLaptops(laptops, criteria);
        for (Laptop laptop : filteredLaptops) {
            System.out.println("Модель: " + laptop.brand + ", ОС: " + laptop.os + ", RAM: " + laptop.ram + "GB, HDD: " + laptop.hardDiskSize + "GB, Цвет: " + laptop.color);
        }
    }
}