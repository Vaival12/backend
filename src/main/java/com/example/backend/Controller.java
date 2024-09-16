package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")  // Разрешение запросов с фронтенда
public class Controller {

    @Autowired
    private DataService dataService;

    @PostMapping("/save")
    public String saveData(@RequestBody String data) {
        boolean isSaved = dataService.saveDataToFile(data);
        if (isSaved) {
            return "Данные успешно сохранены!";
        } else {
            return "Ошибка при сохранении данных.";
        }
    }
}
