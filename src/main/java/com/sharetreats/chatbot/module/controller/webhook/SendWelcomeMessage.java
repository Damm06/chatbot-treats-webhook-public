package com.sharetreats.chatbot.module.controller.webhook;

import com.sharetreats.chatbot.module.controller.dto.WelcomeButton;
import com.sharetreats.chatbot.module.controller.dto.WelcomeKeyboard;
import com.sharetreats.chatbot.module.controller.dto.WelcomeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * welcome message 전송 기능을 위한 클래스 입니다.
 */
@RequiredArgsConstructor
@Component
public class SendWelcomeMessage extends ResponseEvent {

    @Value("${viber.auth.token}")
    private String token;

    @Value("${viber.avatar}")
    private String avatar;

    @Value("${viber.welcome-media}")
    private String welcome_media;

    @Override
    public ResponseEntity<WelcomeMessage> execute(String callback) {
        return ResponseEntity.ok(
                WelcomeMessage.of("Viber Treats", avatar,"tracking_data", "picture",
                        "\uD83E\uDD73\uD83C\uDF89 Hello. Welcome to Viber Treats! We have various treats to send to your friends.\n" +
                                "Click " + "\"Show Treats\"" + " to start",
                        WelcomeKeyboard.of("keyboard", false,"#FFFFFF", createButtons()),
                        welcome_media, welcome_media));
    }

    public List<WelcomeButton> createButtons() {
        return Collections.singletonList(WelcomeButton.of());
    }

}
