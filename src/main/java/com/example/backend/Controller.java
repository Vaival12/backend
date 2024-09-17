package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
