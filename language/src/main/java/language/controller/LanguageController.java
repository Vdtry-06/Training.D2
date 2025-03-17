package language.controller;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class LanguageController {
    private final MessageSource messageSource;

    public LanguageController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/message")
    public String getMessage(@RequestParam String code, @RequestParam(defaultValue = "en") String lang) {
        Locale locale = new Locale(lang);
        return messageSource.getMessage(code, null, locale);
    }
}
