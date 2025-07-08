package com.amazon.automation.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AIService {

    private final ChatModel chatModel;

    @Autowired
    public AIService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    /**
     * 使用AI分析亚马逊产品数据
     * 
     * @param productData 产品数据
     * @return AI分析结果
     */
    public String analyzeProductData(String productData) {
        String systemPromptTemplate = """
                                      你是一个亚马逊产品分析专家。
                                      请分析以下产品数据并提供优化建议：
                                      - 销售趋势分析
                                      - 竞争对手分析
                                      - 价格优化建议
                                      - 关键词优化建议
                                      数据: {productData}
                                      """;

        
        PromptTemplate promptTemplate = new PromptTemplate(systemPromptTemplate);
        Message systemMessage = new SystemMessage(promptTemplate.render(Map.of("productData", productData)));
        Message userMessage = new UserMessage("请提供详细分析");
        
        Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
        ChatResponse response = chatModel.call(prompt);
        
        return response.getResult().getContent().toString();
    }
    
    /**
     * 生成产品描述
     * 
     * @param productInfo 产品信息
     * @return 生成的产品描述
     */
    public String generateProductDescription(String productInfo) {
        String systemPromptTemplate = """
                                      你是一个亚马逊产品描述撰写专家。
                                      根据以下产品信息，创建一个吸引人的产品描述：
                                      - 突出产品的主要特点和优势
                                      - 使用吸引人的语言
                                      - 包含关键词以优化SEO
                                      - 长度控制在500字以内
                                      产品信息: {productInfo}
                                      """;

        
        PromptTemplate promptTemplate = new PromptTemplate(systemPromptTemplate);
        Message systemMessage = new SystemMessage(promptTemplate.render(Map.of("productInfo", productInfo)));
        Message userMessage = new UserMessage("生成产品描述");
        
        Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
        ChatResponse response = chatModel.call(prompt);
        
        return response.getResult().getContent().toString();
    }
}