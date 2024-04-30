package com.java.ia.langchainlearning.OpenAiController;

import com.java.ia.langchainlearning.dtos.input.MyQuestionDtoInput;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAiController {

    @Value("${api.key.openai}")
    private String keyOpenAi;

    /*
    Exemplo de Requisição simples com ChatLanguageModel

    @Autowired
    private ChatLanguageModel chatModel;

    @PostMapping("/answer")
    public String chatWithOpenAi(@RequestBody MyQuestionDtoInput myQuestionDtoInput) {
        return chatModel.generate(myQuestionDtoInput.myQuestion());
    }
     */

    @PostMapping("/answer")
    public String chatWithOpenAi(@RequestBody MyQuestionDtoInput myQuestionDtoInput) {
        ChatLanguageModel customModel = new OpenAiChatModel.OpenAiChatModelBuilder()
                .apiKey(keyOpenAi)
                .modelName("gpt-3.5-turbo")
                .temperature(0.1)
                .build();
        return customModel.generate(myQuestionDtoInput.myQuestion());


    }
}
