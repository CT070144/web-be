package com.kma.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

//    @Bean
//    public FirebaseApp firebaseApp() throws IOException {
//        // Đường dẫn tới file firebase-adminsdk.json
//        FileInputStream serviceAccount =
//                new FileInputStream("src/main/resources/webcnttkma-firebase-adminsdk-mpsu6-ac2c4a48ff.json");
//
//        FirebaseOptions options = FirebaseOptions.builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .build();
//
//        return FirebaseApp.initializeApp(options);
//    }
}
