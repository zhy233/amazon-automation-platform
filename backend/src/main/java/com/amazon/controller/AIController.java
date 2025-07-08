package com.amazon.controller;

import com.amazon.automation.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*") // 开发环境允许所有跨域请求
public class AIController {

    private final AIService aiService;

    @Autowired
    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/analyze-product")
    public ResponseEntity<String> analyzeProduct(@RequestBody String productData) {
        String analysis = aiService.analyzeProductData(productData);
        return ResponseEntity.ok(analysis);
    }

    @PostMapping("/generate-description")
    public ResponseEntity<String> generateDescription(@RequestBody String productInfo) {
        String description = aiService.generateProductDescription(productInfo);
        return ResponseEntity.ok(description);
    }
}