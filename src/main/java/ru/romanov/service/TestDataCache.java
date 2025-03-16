package ru.romanov.service;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class TestDataCache {
    private List<String> inns = new ArrayList<>();
    private List<String> kpps = new ArrayList<>();

    @PostConstruct
    public void init() {
        try {
            // В папке resources лежит файл testData.json с данными, которые надо встаивть в листы inns и kpps.
            // Считываем свойства этого файла
            File file = ResourceUtils.getFile("classpath:testData.json");

            // Считываем содержимое файла
            String testData = new String(Files.readAllBytes(file.toPath()));

            // Далее необходимо достать список ИНН из содержимого файла и добавить его элементы в лист inns.
            // То же самое сделать для КПП
            // Подсказка - можно использовать ObjectMapper для чтения json в модель
        } catch (Exception e) {
            // Эта конструкция необходима, чтобы в случае ошибок чтения из файла спринг все равно мог запуститься.
            // Ошибки все равно будут напечатаны в консоль, но не помешают запуску спринга
            e.printStackTrace();
        }
    }
}
