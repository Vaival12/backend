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
    @GetMapping("/getBackend")
    public ResponseEntity<String> getBackendData() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return new ResponseEntity<>(content.toString(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Ошибка при чтении данных", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
