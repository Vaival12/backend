package com.example.backend;

import org.springframework.web.bind.annotation.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:8082")
public class DataController {

    @PostMapping("/submitData")
    public String submitData(@RequestParam String input) {
        try (FileWriter writer = new FileWriter("data.txt", true)) {
            writer.write(input + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            return "Error saving data";
        }
        return "Data saved successfully";
    }

    @GetMapping("/readData")
    public String readData() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("data.txt"));
            return String.join("<br>", lines);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading data";
        }
    }
}
