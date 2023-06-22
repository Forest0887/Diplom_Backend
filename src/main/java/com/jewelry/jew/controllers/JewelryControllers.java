package com.jewelry.jew.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import com.jewelry.jew.entity.Jewelry;
import com.jewelry.jew.repository.JewelryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class JewelryControllers {

    private final JewelryRepository jewelryRepository;

    public JewelryControllers(JewelryRepository jewelryRepository) {
        this.jewelryRepository = jewelryRepository;
    }

    @GetMapping("/jewelry/show-list")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Jewelry> getAllJewelry() {
        return (List<Jewelry>) jewelryRepository.findAll();
    }

    @PostMapping("/jewelry/add")
    @CrossOrigin(origins = "http://localhost:4200")
    void addJewelry(@RequestParam("picture") MultipartFile picture, @RequestParam("jewelry") MultipartFile jewelry) {
        try {
            String content = new String(jewelry.getBytes());
            ObjectMapper mapper = new ObjectMapper();
            Jewelry jewelryEntity = mapper.readValue(content, Jewelry.class);

            byte[] pictureByteArray = {};
            try {
                pictureByteArray = picture.getBytes();
            } catch (IOException e) {
                System.out.println("Failed to get bytecode picture");
            }

            // для сохранения фото в директории проекта
            //File pictureFile = new File(".\\data\\" + jewelryEntity.getName_id() + ".jpg");

            // для сохранения фото в директории фронта
            // TODO (ПОМЕНЯТЬ ПРИ РАЗВЕРТЫВАНИИ)
            File pictureFile = new File("C:\\Users\\skyne\\Desktop\\Diplom\\WebSite_Angular\\my-app\\" +
                    "src\\assets\\img\\" + jewelryEntity.getName_id() + ".jpg");

            try {
                Files.write(pictureFile.toPath(), pictureByteArray);
            } catch (IOException e) {
                System.out.println("Failed to save picture file to storage");
            }
            jewelryEntity.setPathToPic("\\assets\\img\\" + jewelryEntity.getName_id()  + ".jpg");
            // здесь можешь вытащить путь к файлу с помощью pictureFile.getPath() и сохранить его в jewelry


            jewelryRepository.save(jewelryEntity);
        } catch (IOException e) {
            System.out.println("Failed to get jewelry bytecode");
        }
    }

    //  сделать, чтоб на фронте сохранялся id изделия и после отправлялся на бек при удалении
    @PostMapping("/jewelry/{id}/remove")
    void removeJewelryById(@PathVariable(value = "id") long id) {
        jewelryRepository.deleteById(id);
    }

    @PostMapping("/jewelry/{id}/update")
    void updateJewelry(@PathVariable(value = "id") long id, @RequestParam String name) {
        Optional<Jewelry> jewelryOpt = jewelryRepository.findById(id);
        if (jewelryOpt.isPresent()){
            final Jewelry jewelry = jewelryOpt.get();
            jewelryRepository.save(new Jewelry(jewelry.getId(), name));
        }
    }
}